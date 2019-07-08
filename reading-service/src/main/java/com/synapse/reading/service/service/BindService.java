package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.model.Bind;
import com.synapse.reading.remote.GatwayService;
import com.synapse.reading.respository.respository.BindRespository;
import com.synapse.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class BindService extends BindBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private BindRespository bindRespository;

    @Autowired
    private GatwayService gatwayService;
    @Autowired
    private  BindService  bindService;

    private static Logger logger = LoggerFactory.getLogger(BindService.class);

    public Bind find(String recId) {
        return bindRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Bind param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return bindRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Bind param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
       param.setRecId(idService.gen("ID"));
//        param.setRecId("111111");
        param.setCreateTime(now);
        param.setUpdateTime(now);
        bindRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return bindRespository.deleteByPrimaryKey(recId);
    }

    public List<Bind> list(Bind bindParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(bindParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return bindRespository.list(params);
    }

    public Integer count(Bind bindParam) {
        Map<String, Object> params = prepareParams(bindParam);
        return bindRespository.count(params);
    }


    public Bind isBindByUnionId(String unionId) {
        List<Bind> bind = bindRespository.selectByUnionId(unionId);
        if (bind != null && bind.size() > 0) {
            return bind.get(0);
        }
        return null;
    }

    public Bind isBindByOpenId(String openId) {
        List<Bind> bind = bindRespository.selectByOpenId(openId);
        if (bind != null && bind.size() > 0) {
            return bind.get(0);
        }
        return null;
    }

    public Bind isUser(String userId) {
        List<Bind> bind = bindRespository.selectByUserId(userId);
        if (bind != null && bind.size() > 0) {
            return bind.get(0);
        }
        return null;
    }


    public Map<String, String> judge4MiniApp(Map<String, String> userInfo) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            if (null == userInfo.get("unionid")) {
                Bind bind = isBindByOpenId((String) userInfo.get("openid"));
                if (null != bind) {
                    map.put("userId", (String) bind.getUserId());
                    map.put("code", "200");
                    return map;
                }else {
                    User user =new User("", userInfo.get("nickName"),userInfo.get("password"));
                    Map<String, Object> param = new HashMap();
                    param.put("regWay", userInfo.get("regWay"));
                    user.setParams(param);
                    String userId  = gatwayService.create(user);
                    Bind bind1 =new Bind();
                    bind1.setUserId(userId);
                    bind1.setOpenId(userInfo.get("openid"));
                    logger.info("--------------------------20190628openId 2=" + userInfo.get("openId"));
                    String bindId1 = bindService.create(bind1);
                    logger.warn("-------------bindId=="+bindId1);
                    map.put("userId", userId);
                    map.put("code", "200");
                    return map;
                }

            }

            Bind bind = isBindByUnionId(userInfo.get("unionid"));
            logger.warn("-----------------d4sdffsdx");
            //如果绑定过
            if (null != bind) {
                map.put("userId", (String) bind.getUserId());
                map.put("code", "200");
                return map;
            } else {
                Bind bind1 = isBindByOpenId((String) userInfo.get("openid"));
                if (null != bind1) {
                    //当小程序登陆有unionId;但是没有找到对应的用户；这时使用openID能找到；则将unionId插入进去；补充之前没有unionId 的记录
                    bind1.setUnionId(userInfo.get("unionid"));
                    bindRespository.updateByPrimaryKeySelective(bind1);
                    map.put("userId", (String) bind1.getUserId());
                    map.put("code", "200");
                    return map;
                }else{
                    User user =new User("", userInfo.get("nickName"),userInfo.get("password"));
                    Map<String, Object> param = new HashMap();
                    param.put("regWay", userInfo.get("regWay"));
                    user.setParams(param);
                    String userId  = gatwayService.create(user);
                    Bind bind2 =new Bind();
                    bind2.setUserId(userId);
                    bind2.setOpenId(userInfo.get("openid"));
                    logger.info("--------------------------20190628openId 3=" + userInfo.get("openid"));
                 String bindId = bindService.create(bind2);
                    logger.warn("-------------bindId=="+bindId);
                    map.put("userId", userId);
                    map.put("code", "200");
                    return map;
                }
            }
        } catch (Exception e) {
            logger.warn("-----------------e=",e);
            map.put("code", "500");
            return map;

        }

    }


}