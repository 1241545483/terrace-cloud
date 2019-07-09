package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.model.ClassInfo;
import com.synapse.reading.model.OrgCode;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.respository.OrgCodeRespository;
import com.synapse.reading.dto.param.OrgCodeParam;
import com.synapse.reading.dto.result.OrgCodeResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.OrgCodeConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-07-08
 */
@Service
@Transactional
public class OrgCodeService extends OrgCodeBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private OrgCodeRespository orgCodeRespository;
    @Autowired
    private ShortLinkApiService shortLinkApiService;
    @Autowired
    private MiniQrcodeService miniQrcodeService;
    @Autowired
    private Gson gson;

    public OrgCode find(String recId){
	    return orgCodeRespository.selectByPrimaryKey(recId);
    }

	public Integer update(OrgCode param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return orgCodeRespository.updateByPrimaryKeySelective(param);
    }

    public String create(OrgCode param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(OrgCodeConstants.STATUS.OK.num());
        orgCodeRespository.insertAndGet(param);
        OrgCode code  = getClassQrCode(param);
        orgCodeRespository.updateByPrimaryKeySelective(code);
        return param.getOrgCode().toString();
    }

    public OrgCode getClassQrCode(OrgCode param) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/org/org/join");
        Map<String, String> params = new HashMap<>();
        params.put("orgCode", param.getOrgCode().toString());
        Result result = shortLinkApiService.getCodeByUrl(gson.toJson(params));
        if (result != null && result.getCode() == 200) {
            String body = (String) result.getBody();
            String scene = org.apache.commons.lang3.StringUtils.substringAfterLast(body, "/");
            miniQrcodeParam.setScene(scene);
        } else {
            throw new RuntimeException(result.getMsg());
        }
        miniQrcodeParam.setWidth("110");
        try {
            String generate = miniQrcodeService.generate(miniQrcodeParam);
            param.setQrCode(generate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        OrgCode model = new OrgCode();
        model.setOrgCode(Integer.parseInt(recId));
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(OrgCodeConstants.STATUS.DELETED.num());
        return orgCodeRespository.updateByPrimaryKeySelective(model);
    }

	public List<OrgCode> list(OrgCode orgCodeParam, PageInfo pageInfo) {
		orgCodeParam.setStatus(OrgCodeConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(orgCodeParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return orgCodeRespository.list(params);
	}

	public Integer count(OrgCode orgCodeParam) {
		orgCodeParam.setStatus(OrgCodeConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(orgCodeParam);
        return orgCodeRespository.count(params);
    }

}