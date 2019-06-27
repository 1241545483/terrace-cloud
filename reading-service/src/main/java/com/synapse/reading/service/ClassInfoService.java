package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.ClassCodeConstants;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.model.ClassCode;
import com.synapse.reading.model.ClassInfo;
import com.synapse.reading.model.ClassStudentMapping;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.respository.ClassInfoRespository;
import com.synapse.reading.dto.param.ClassInfoParam;
import com.synapse.reading.dto.result.ClassInfoResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ClassInfoConstants;
import com.synapse.reading.remote.IdService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class ClassInfoService extends ClassInfoBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private ClassInfoRespository classInfoRespository;

    @Autowired
    private Gson gson;
    @Autowired
    private ShortLinkApiService shortLinkApiService;
    @Autowired
    private MiniQrcodeService miniQrcodeService;
    @Autowired
    private ClassCodeService classCodeService;
    @Autowired
    private ClassStudentMappingService classStudentMappingService;

    public ClassInfo find(String recId) {
        return classInfoRespository.selectByPrimaryKey(recId);
    }

    public ClassInfoResult getByClassCode(String classCode) {
        return classInfoRespository.getByClassCode(classCode);
    }

    public Integer update(ClassInfo param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return classInfoRespository.updateByPrimaryKeySelective(param);
    }

    public String createClassStudent(String classCode, String studentId,String realName) {
        ClassStudentMapping param = new ClassStudentMapping();
        param.setClassId(classCode);
        param.setStudentId(studentId);
        param.setRealName(realName);
        classStudentMappingService.create(param);
        return param.getRecId();
    }

    public String create(ClassInfo param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(ClassInfoConstants.STATUS.OK.num());
        ClassCode classCode = new ClassCode();
        classCode.setStatus(ClassCodeConstants.STATUS.OK.num());
        String code = classCodeService.create(classCode);
        param.setClassCode(code);
        getClassQrCode(param);
        classInfoRespository.insert(param);
        return param.getRecId();
    }

    public ClassInfo getClassQrCode(ClassInfo param) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/class/class/join");
        Map<String, String> params = new HashMap<>();
        params.put("classCode", param.getClassCode());
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
        ClassInfo model = new ClassInfo();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ClassInfoConstants.STATUS.DELETED.num());
        return classInfoRespository.updateByPrimaryKeySelective(model);
    }

    public List<ClassInfo> list(ClassInfo classInfoParam, PageInfo pageInfo) {
        classInfoParam.setStatus(ClassInfoConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(classInfoParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return classInfoRespository.list(params);
    }

    public List<ClassInfoResult> listByTeacherCreate(String userId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return classInfoRespository.listByTeacherCreate(params);
    }

    public List<ClassInfoResult> listByStudentJoin(String userId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return classInfoRespository.listByStudentJoin(params);
    }

    public Integer count(ClassInfo classInfoParam) {
        classInfoParam.setStatus(ClassInfoConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(classInfoParam);
        return classInfoRespository.count(params);
    }

    public Integer countByTeacherCreate(String userId) {
        return classInfoRespository.countByTeacherCreate(userId);
    }

    public Integer countByStudentJoin(String userId) {
        return classInfoRespository.countByStudentJoin(userId);
    }

}