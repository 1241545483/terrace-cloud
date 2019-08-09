package com.synapse.reading.service;

import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.service.auth.ModelOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查用户是否有权限
 * Created by wangyifan on 19-5-29.
 */
@Service
@Transactional
public class ValidService {

    private Logger logger = LoggerFactory.getLogger(ValidService.class);

    @Autowired
    private ModelOperateService modelOperateService;

    public boolean valid(String roleCode) {

        logger.info("start check roleCode");

        User user = UserContext.getUser();

        if (user == null) {
            logger.info("is not login!");
            return false;
        }

        if (user.getRecId().equals(CommonConstants.anonymousId)) {
            logger.info("is anonymous!");
            return false;
        }

        int num = modelOperateService.checkUserOperate(user.getRecId(), roleCode);

        logger.info("check user[{}] roleCode [{}] is [{}]", user.getUsername(), roleCode, num);

        return num > 0;
    }
}
