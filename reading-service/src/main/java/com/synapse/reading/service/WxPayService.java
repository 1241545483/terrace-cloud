package com.synapse.reading.service;

import com.synapse.common.utils.DateUtils;
import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.util.AESDecodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Random;


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
        return tradeOrderRespository.updateByPrimaryKeySelective(tradeOrder);
    }

}
