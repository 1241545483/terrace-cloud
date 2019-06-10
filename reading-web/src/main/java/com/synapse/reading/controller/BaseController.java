package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.constants.UserConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 组织基本的PageInfo对象
     *
     * @param currentPage
     * @param perPageSize
     * @return
     */
    public PageInfo buildPageInfo(int currentPage, int perPageSize) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (perPageSize < 3 || perPageSize > 300) {
            perPageSize = 10;
        }
        PageInfo page = new PageInfo();
        page.setCurrentPageIndex(currentPage);
        page.setPerPageNum(perPageSize);
        return page;
    }

    /**
     * 组织基本的PageInfo对象
     *
     * @param page
     * @return
     */
    public PageInfo buildPageInfo(PageInfo page) {
        if (page.getCurrentPageIndex() <= 0) {
            page.setCurrentPageIndex(1);
        }
        if (page.getPerPageNum() < 3 || page.getPerPageNum() > 10000) {
            page.setPerPageNum(10);
        }
        return page;
    }

    /**
     * 是否是创建者
     * @param user
     * @param createdId
     * @return
     */
    public boolean isCreator(User user, Long createdId) {
    	if(null == user ||null == createdId) {
    		return false;
    	}
    	if(null == user.getRecId() ) {
    		return false;
    	}
    	if(StringUtils.trimToEmpty(String.valueOf(createdId.longValue())).equals(StringUtils.trimToEmpty(user.getRecId()))) {
    		return true;
    	}
    	return false;
    }
    /**
     * 校验是否为管理员
     * 用于执行管理员权限前的校验，如果不是管理员则抛异常
     */
//    public boolean isAdmin() {
//        User user = UserContext.getUser();
//        if (user == null) {
//            logger.info("没有登录！");
//            return false;
//        }
//        Map<String, List<Map<String, String>>> roles = user.getBizRoles();
//        //如果没有则抛出异常
//        //根据shilu系统标识获取该用户在该系统的角色
//        List<Map<String, String>> userInfos = roles.get("SHILU");
//        if (roles == null || userInfos == null || userInfos.size() == 0) {
//            logger.info("该用户尚未授予权限");
//            return false;
//        }
//        List<String> roleCodes = new ArrayList<>();
//        for (Map<String, String> userInfo : userInfos) {
//            roleCodes.add(userInfo.get("bizroleId"));
//        }
//
//        for (String roleCode : roleCodes) {
//            if (null != roleCode && roleCode.trim().toLowerCase().equals("admin")) {
//                //只要在角色列表中有“admin”角色，验证成功并返回，没有admin角色则抛出异常
//                return true;
//            }
//        }
//        return false;
//    }

    public void preparePageInfo(PageInfo pageInfo, int totalNum) {
        if (pageInfo.getCurrentPageIndex() < 1) {
            pageInfo.setCurrentPageIndex(CommonConstants.DEFAULT_CURRENTPAGE);
        }
        if (pageInfo.getPerPageNum() == 0) {
            pageInfo.setPerPageNum(10);
        }
        pageInfo.setTotalNum(totalNum);
    }
    
    
//    public int getAuth(User user, Long principatId, Long projectId) {
//        int managerFlag = -1;
//        String userId = null;
//        if (null != user) {
//        	 userId = StringUtils.trimToEmpty(user.getRecId());
//            user.getBizRoles();
//            if (principatId != null && userId.equals(StringUtils.trimToEmpty(principatId.toString()))) {
//                //判断是否有最大权限
//                managerFlag = UserConstants.FLAG.CREATOR.value();
//            }
//            //判断是否为管理员
//            if (isAdmin()) {
//                managerFlag = UserConstants.FLAG.ADMIN.value();
//                return managerFlag;
//            }
//            //判断是否为区管理员
//            if (isAppointedAuth(UserConstants.ROLE.AREA_MANAGER.num)) {
//            	managerFlag = UserConstants.FLAG.AREA_MANAGER.value();
//            	return managerFlag;
//            }
//        }
//        //查询是否是区管理员
//        return managerFlag;
//    }
    
    /**
     * 获取权限(校管理， 区管理)
     * @param user
     * @return
     */
//    public List<String> getRoles(User user) {
//        Map<String, List<Map<String, String>>> roles = user.getBizRoles();
//        List<String> rolesArray = new ArrayList<String>();
//        //根据角色判断权限
//        if (roles != null && roles.size() > 0) {
//            List<Map<String, String>> userInfos = roles.get("SHILU");
//            if (userInfos == null || userInfos.size() == 0) {
//                return rolesArray;
//            }
//        }
//        List<Map<String, String>> userInfos = roles.get("SHILU");
//        List<String> roleCodes = new ArrayList<>();
//        for (Map<String, String> userInfo : userInfos) {
//            roleCodes.add(userInfo.get("bizroleId"));
//        }
//        if (null != roleCodes) {
//            for (String role : roleCodes) {
//                //转化role为code
//                String code = StringUtils.trimToEmpty(UserConstants.ROLE.nameOf(role));
//                if (code.length() > 0) {
//                    rolesArray.add(code);
//                }
//            }
//            return rolesArray;
//        }
//        return rolesArray;
//    }
//
    /**
     * 获取权限
     * @param user
     * @return
     */
//    public String getRolestr(User user) {
//    	List<String> list = getRoles(user);
//    	if(null != list && list.size() > 0) {
//    		String roleStr = "";
//    		for(String s : list) {
//    			roleStr += s + CommonConstants.SEP_COMMA;
//    		}
//    		if(roleStr.length() > 0) {
//    			roleStr = roleStr.substring(0,  roleStr.length() - 1);
//    		}
//    		return roleStr;
//    	}
//    	return "";
//    }
    
    /**
     * 是否有管理权限
     *
     * @param managerFlag
     * @return
     */
    public boolean hasManageAuth(int managerFlag) {
        if (managerFlag == UserConstants.FLAG.ADMIN.value()
        		|| managerFlag == UserConstants.FLAG.AREA_MANAGER.value()
        		|| managerFlag == UserConstants.FLAG.CREATOR.value()
        		|| managerFlag == UserConstants.FLAG.COLLABORATOR.value()) {
            return true;
        }
        return false;
    }

    /**
     * 角色列表是否有指定的角色
     *
     * @param appointAuth
     * @param userRoleList
     * @return
     */
//    public boolean isAppointedAuth(String appointAuth) {
//        List<String> userRoleList = getRoles(UserContext.getUser());
//        logger.info("userRoleList is {} ! appointAuth = {}", userRoleList, appointAuth);
//        if (StringUtils.trimToEmpty(appointAuth).equals("") || userRoleList == null || userRoleList.size() == 0) {
//            return false;
//        }
//        for (String userRole : userRoleList) {
//            if (appointAuth.equals(userRole)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
