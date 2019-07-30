package com.synapse.reading.service;

import com.synapse.common.utils.DateUtils;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.service.auth.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VipService {

    @Autowired
    private TradeOrderService tradeOrderService;
    @Autowired
    private TradeOrderRespository tradeOrderRespository;
    @Autowired
    private UserRoleService userRoleService;

    private Logger logger = LoggerFactory.getLogger(VipService.class);

    public void task() {
        logger.info("start task");

        userRoleService.delete("1123");
        new RuntimeException();
//        List<String> userIds = tradeOrderRespository.findVipUser();
//        if (userIds != null && userIds.size() > 0) {
//            for (String userId : userIds) {
//                logger.info("vip task-----------------------userId="+userId);
//                List<TradeOrder> tradeOrderList = tradeOrderService.findVipByBuyId(userId);
//                if (vipPast(tradeOrderList.get(0).getEndTime())) {
//                    String id = userRoleService.vipByUserId(userId);
//                    logger.info("vip task-----------------------id="+id);
//                    if (id != null && !"".equals(id)) {
//                        userRoleService.deleteVipByUserId(userId);
//                    }
//                }
//            }
//        }




        logger.info("end task");
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
}
