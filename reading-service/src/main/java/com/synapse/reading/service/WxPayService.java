package com.synapse.reading.service;

import com.synapse.common.utils.DateUtils;
import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.model.auth.UserRole;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.service.auth.UserRoleService;
import com.synapse.reading.util.AESDecodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <p>
 * 支付 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Service
@Transactional
public class WxPayService {

    @Autowired
    private IdService idService;

    @Autowired
    private TradeOrderRespository tradeOrderRespository;

    @Autowired
    private TradeOrderDetailRespository tradeOrderDetailRespository;
    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;
    @Autowired
    private UserRoleService userRoleService;


    //生成商户订单号
    public String getRandomOrderId() {
        Random random = new Random(System.currentTimeMillis());
        int value = random.nextInt();
        while (value < 0) {
            value = random.nextInt();
        }
        return value + "";
    }

    //解密encryptedData 获取前台传过来的openid
    public String getOpenid(Map<String, String> param) {
        String openid = null;
        if (param.get("encryptedData") != null) {
            String phoneData = null;
            try {
                phoneData = AESDecodeUtils.decryptPre(param.get("encryptedData"), param.get("iv"), param.get("sessionkey"));
                Map map = JsonUtils.toObject(phoneData, Map.class);
                openid = String.valueOf(map.get("openId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return openid;
    }

    //后台生成自己的订单（用来和实际 的支付订单同步，并返回前台）
    public String create(TradeOrderParam param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        if ("vip".equals(param.getTradeOrderDetailParamArrayList().get(0).getProdType())) {
            String days = "365";
            List<TradeOrder> tradeOrderList = tradeOrderRespository.findVipByBuyId(param.getBuyId());
            try {
                if (tradeOrderList != null && tradeOrderList.size() > 0) {
                    //获取时间加一年
                    if (!vipPast(tradeOrderList.get(0).getEndTime())) {
                        String endTime = addYear(tradeOrderList.get(0).getEndTime(), days);
                        param.setStartTime(tradeOrderList.get(0).getEndTime());
                        param.setEndTime(endTime);
                    } else {
                        param.setStartTime(now);
                        param.setEndTime(addYear(now, days));
                    }
                } else {
                    param.setStartTime(now);
                    param.setEndTime(addYear(now, days));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "系统时间异常";
            }
        }
        param.setStatus(TradeOrderConstants.STATUS.UNPAID.num());
        tradeOrderRespository.insert(param.getModel());
        if (param.getTradeOrderDetailParamArrayList() != null && !"".equals(param.getTradeOrderDetailParamArrayList())) {
            for (TradeOrderDetailParam tradeOrderDetail : param.getTradeOrderDetailParamArrayList()) {
                tradeOrderDetail.getModel().setRecId(idService.gen("ID"));
                tradeOrderDetail.getModel().setCreateTime(now);
                tradeOrderDetail.getModel().setTrateOrderId(param.getRecId());
                tradeOrderDetail.getModel().setUpdateTime(now);
                tradeOrderDetail.getModel().setStatus(TradeOrderConstants.STATUS.OK.num());
                tradeOrderDetailRespository.insert(tradeOrderDetail.getModel());
            }
        }
        return param.getRecId();
    }

    //todo 后台支付完成后，同步修改生成的订单状态，修改为已完成状态（订单分为待完成，完成，删除三个状态），
    public Integer updateOrder(Map<String, Object> map) {
        TradeOrder tradeOrder = tradeOrderRespository.selectByPrimaryKey(map.get("orderNo") + "");
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        tradeOrder.setPayNo(map.get("serialNo") + "");
        tradeOrder.setIntro(map.get("attach") + "");
        tradeOrder.setPayWay(map.get("channel") + "");
        tradeOrder.setUpdateTime(now);
        tradeOrder.setFinishTime(now);
        tradeOrder.setStatus(TradeOrderConstants.STATUS.OK.num());
        List<TradeOrderDetail> tradeOrderDetailList = tradeOrderDetailRespository.findByTradeOrder(tradeOrder.getRecId());
        if ("vip".equals(tradeOrderDetailList.get(0).getProdType())) {
            userRoleCreate(tradeOrder.getBuyId());
        }
        return tradeOrderRespository.updateByPrimaryKeySelective(tradeOrder);
    }

    //比较用户会员是否过期
    public Boolean vipPast(String endTime) {
        try {
            DateFormat sdf = new SimpleDateFormat(DateUtils.FORMAT_DATE_TIME);
            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
            Date startTime = sdf.parse(now);
            Date lastTime = sdf.parse(endTime);
            if (lastTime.getTime() < startTime.getTime()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    //创建用户角色
    public void userRoleCreate(String userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId("vip");
        userRole.setCreateId(userId);
        userRoleService.create(userRole);
    }

    //增加时间
    public String addYear(String startTime, String days) throws Exception {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime = sdf.parse(startTime); //String转Date
        Calendar cal = Calendar.getInstance();
        cal.setTime(createTime);//设置起时间
        cal.add(Calendar.DATE, Integer.parseInt(days));//增加天数
        return sdf.format(cal.getTime());
    }


}
