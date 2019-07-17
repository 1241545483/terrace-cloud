package com.synapse.reading.service.auth;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.auth.WxLoginState;
import com.synapse.reading.respository.auth.WxLoginStateRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.auth.WxLoginStateConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class WxLoginStateService extends WxLoginStateBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private WxLoginStateRespository wxLoginStateRespository;

    public WxLoginState find(String recId){
	    return wxLoginStateRespository.selectByPrimaryKey(recId);
    }

	public Integer update(WxLoginState param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return wxLoginStateRespository.updateByPrimaryKeySelective(param);
    }

    public String create(WxLoginState param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setStatus(WxLoginStateConstants.STATUS.OK.num());
        wxLoginStateRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        WxLoginState model = new WxLoginState();
        model.setRecId(recId);
        model.setStatus(WxLoginStateConstants.STATUS.DELETED.num());
        return wxLoginStateRespository.updateByPrimaryKeySelective(model);
    }

	public List<WxLoginState> list(WxLoginState wxLoginStateParam, PageInfo pageInfo) {
		wxLoginStateParam.setStatus(WxLoginStateConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(wxLoginStateParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return wxLoginStateRespository.list(params);
	}

	public Integer count(WxLoginState wxLoginStateParam) {
		wxLoginStateParam.setStatus(WxLoginStateConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(wxLoginStateParam);
        return wxLoginStateRespository.count(params);
    }

}
