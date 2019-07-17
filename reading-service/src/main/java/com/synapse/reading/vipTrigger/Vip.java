package com.synapse.reading.vipTrigger;

import com.synapse.common.utils.DateUtils;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.service.TradeOrderService;
import com.synapse.reading.service.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
@EnableScheduling
public class Vip {
    @Autowired
    private TradeOrderService tradeOrderService;
    @Autowired
    private TradeOrderRespository tradeOrderRespository;
    @Autowired
    private UserRoleService userRoleService;
    private Logger logger = LoggerFactory.getLogger(Vip.class);
    public void task() {
        List<String> userIds = tradeOrderRespository.findVipUser();
        if (userIds != null && userIds.size() > 0) {
            for (String userId : userIds) {
                List<TradeOrder> tradeOrderList = tradeOrderService.findVipByBuyId(userId);
               if(vipPast(tradeOrderList.get(0).getEndTime())){
                  userRoleService.deleteVipByUserId(userId);
               }
            }
        }

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
