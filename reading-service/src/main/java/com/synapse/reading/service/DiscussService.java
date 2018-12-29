package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.constants.DiscussConstants;
import com.synapse.reading.dto.result.DiscussResult;
import com.synapse.reading.model.Discuss;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.respository.DiscussRespository;
import com.synapse.user.model.UserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Service
@Transactional
public class DiscussService extends DiscussBaseService {

    @Autowired
    private IdService idService;
    @Autowired
    private UserService userService;

    @Autowired
    private DiscussRespository discussRespository;

    private Logger logger = LoggerFactory.getLogger(DiscussService.class);

    public Discuss find(String recId) {
        return discussRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Discuss param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        return discussRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Discuss param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setStatus(DiscussConstants.STATUS.OK.num());
        discussRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Discuss model = new Discuss();
        model.setRecId(recId);
        model.setStatus(DiscussConstants.STATUS.DELETED.num());
        return discussRespository.updateByPrimaryKeySelective(model);
    }

    public List<Discuss> list(Discuss discussParam, PageInfo pageInfo) {
        discussParam.setStatus(DiscussConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(discussParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return discussRespository.list(params);
    }

    public List<DiscussResult> listByCommentType(Discuss discussParam, PageInfo pageInfo) {
        discussParam.setStatus(DiscussConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(discussParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        List<DiscussResult> discusses = discussRespository.listByCommentType(params);
        logger.error("discusses---------------------------------{}",discusses);
        List<String> useridList = new ArrayList<>();
        if (discusses!=null &&discusses.size()!=0){
            for (DiscussResult discuss:discusses){
                useridList.add(discuss.getCreateId());
                logger.error("discuss---------------------------------{}",discuss);
            }
            String userIdListStr = StringUtils.join(useridList.toArray());
            logger.error("userIdListStr---------------------------------{}",userIdListStr);
            ArrayList<UserInfo> userList=  userService.selectByUserIdList(userIdListStr);
            logger.error("userList---------------------------------{}",userList);
            for (DiscussResult discuss:discusses){
                logger.error("discuss---------------------------------{}",discuss);
                for (UserInfo user:userList){
                    logger.error("user---------------------------------{}",user);
                    if (user.getUserId().equals(discuss.getCreateId())){
                        logger.error("user.getUserId()---------------------------------{}",user.getUserId());
                        logger.error("user.getCreateId()---------------------------------{}",discuss.getCreateId());
                        logger.error("user.getUserName()---------------------------------{}",user.getUserName());
                        logger.error("user.getUserImg()---------------------------------{}",user.getUserImg());
                        discuss.setUserName(user.getUserName());
                        logger.error("user.getUserName()---------------------------------{}",discuss.getUserName());
                        discuss.setUserImg(user.getUserImg());
                    }
                }
            }
        }

        return discusses;
    }

    public Integer count(Discuss discussParam) {
        discussParam.setStatus(DiscussConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(discussParam);
        return discussRespository.count(params);
    }


    public boolean updateDiscussLikeAddNum(String recId) {
        return discussRespository.updateDiscussLikeAddNum(recId) > 0;
    }

    public boolean updateDiscussLikeReduceNum(String recId) {
        return discussRespository.updateDiscussLikeReduceNum(recId) > 0;
    }


}