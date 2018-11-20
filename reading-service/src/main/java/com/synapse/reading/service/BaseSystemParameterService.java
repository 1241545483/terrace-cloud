package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.dto.result.BaseSystemParameterResult;
import com.synapse.reading.model.BaseSystemParameter;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.BaseSystemParameterRespository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Transactional
@Service
public class BaseSystemParameterService {

    @Autowired
    private BaseSystemParameterRespository baseSystemParameterRespository;

    @Autowired
    private IdService idService;

    private static final Object o = new Object();

    private static Map<String, List<BaseSystemParameter>> TYPE_MAP = new HashMap<String, List<BaseSystemParameter>>();
    private static Map<String, List<BaseSystemParameter>> PKEY_MAP = new HashMap<>();
    private static Map<String, List<BaseSystemParameter>> PKEY_PTYPE_MAP = new HashMap<String, List<BaseSystemParameter>>();
    private static Map<String, BaseSystemParameter> TYPEKEY_MAP = new HashMap<String, BaseSystemParameter>();
    private static Map<String, BaseSystemParameter> VALUE_MAP = new HashMap<String, BaseSystemParameter>();


    public List<Map<String, String>> superManagerSelect(String sql) {
        return baseSystemParameterRespository.superManagerSelect(sql);
    }

    public int superManagerUpdate(String sql) {
        return baseSystemParameterRespository.superManagerUpdate(sql);
    }

    public int superManagerDelete(String sql) {
        return baseSystemParameterRespository.superManagerDelete(sql);
    }

    /**
     * 初始化缓存
     */
    public void init() {
        System.out.println("初始化。。。。。。。");
        //查询所有的数据
        List<BaseSystemParameter> list = baseSystemParameterRespository.getList(new HashMap<String, Object>());
        if (null == list || list.size() == 0) {
            return;
        }
        buildCacheMap(list);
    }

    /**
     * 缓存信息
     *
     * @param list
     */
    private void buildCacheMap(List<BaseSystemParameter> list) {
        synchronized (o) {
            for (BaseSystemParameter parameter : list) {
                buildTypeMap(parameter);
                buildPKeyTypeMap(parameter);
                buildTypeKeyMap(parameter);
//				buildTypeValueMap(parameter);
            }
            buildPkeyPtypeMap(null);
        }
    }

    private void buildPkeyPtypeMap(BaseSystemParameter parameter) {
        PKEY_PTYPE_MAP.clear();
    }

    private void buildTypeKeyMap(BaseSystemParameter parameter) {
        String type = StringUtils.trimToEmpty(parameter.getParameterType());
        String key = StringUtils.trimToEmpty(parameter.getParameterKey());
        if (type.length() == 0 || key.length() == 0) {
            return;
        }
        String mapKey = type + CommonConstants.SEP_LINE + key;
        if (!TYPEKEY_MAP.containsKey(mapKey)) {
            TYPEKEY_MAP.put(mapKey, parameter);
        }
    }

    private void buildTypeValueMap(BaseSystemParameter parameter) {
        String type = StringUtils.trimToEmpty(parameter.getParameterType());
        String value = StringUtils.trimToEmpty(parameter.getParameterValue());
        if (type.length() == 0 || value.length() == 0) {
            return;
        }
        String mapKey = type + CommonConstants.SEP_LINE + value;
        if (!VALUE_MAP.containsKey(mapKey)) {
            VALUE_MAP.put(mapKey, parameter);
        }

    }

    private void buildTypeMap(BaseSystemParameter parameter) {
        String type = StringUtils.trimToEmpty(parameter.getParameterType());
        if (type.length() == 0) {
            return;
        }
        if (!TYPE_MAP.containsKey(type)) {
            List<BaseSystemParameter> typeList = new ArrayList<BaseSystemParameter>();
            typeList.add(parameter);
            TYPE_MAP.put(type, typeList);
        } else {
            List<BaseSystemParameter> typeList = TYPE_MAP.get(type);
            typeList.add(parameter);
        }

    }

    private void buildPKeyTypeMap(BaseSystemParameter parameter) {
        String pkey = StringUtils.trimToEmpty(parameter.getParentParameterKey());
        String type = StringUtils.trimToEmpty(parameter.getParameterType());
        String mapKey = pkey + CommonConstants.SEP_LINE + type;
        if (pkey.length() == 0 || type.length() == 0) {
            return;
        }
        if (!PKEY_MAP.containsKey(mapKey)) {
            List<BaseSystemParameter> keyList = new ArrayList<BaseSystemParameter>();
            keyList.add(parameter);
            PKEY_MAP.put(mapKey, keyList);
        } else {
            List<BaseSystemParameter> keyList = PKEY_MAP.get(mapKey);
            keyList.add(parameter);
        }
    }

    /**
     * 根据key和type查询
     *
     * @param parameterType
     * @param parameterKey
     * @return
     */
    public BaseSystemParameter getByKeyAndType(String parameterType, String parameterKey) {
        String key = parameterType + CommonConstants.SEP_LINE + parameterKey;
        BaseSystemParameter bsp = TYPEKEY_MAP.get(key);
        if (bsp == null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parameterType", parameterType);
            params.put("parameterKey", parameterKey);
            List<BaseSystemParameter> list = baseSystemParameterRespository.getList(params);
            BaseSystemParameter b = (list == null || list.size() == 0) ? null : list.get(0);
            if (null != b) {
                synchronized (b) {
                    TYPEKEY_MAP.put(key, b);
                }
            }
            return b;
        }
        return bsp;
    }

    /**
     * 根据key和value查询
     *
     * @param parameterType
     * @param parameterValue
     * @return
     */
    public String getKeyByTypeAndValue(String parameterType, String parameterValue) {
        String key = parameterType + CommonConstants.SEP_LINE + parameterValue;
        BaseSystemParameter bsp = VALUE_MAP.get(key);
        if (bsp == null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parameterType", parameterType);
            params.put("parameterValue", parameterValue);
            List<BaseSystemParameter> list = baseSystemParameterRespository.getList(params);
            BaseSystemParameter b = (list == null || list.size() == 0) ? null : list.get(0);
            if (null != b) {
                synchronized (b) {
                    VALUE_MAP.put(key, b);
                }
            }
            return b == null ? "" : b.getParameterKey();
        }
        return bsp.getParameterKey();
    }

    /**
     * 根据key和type查询值
     *
     * @param parameterType
     * @param parameterKey
     * @return
     */
    public String getValueByKeyAndType(String parameterType, String parameterKey) {
        String key = parameterType + CommonConstants.SEP_LINE + parameterKey;
        BaseSystemParameter bsp = TYPEKEY_MAP.get(key);
        if (bsp == null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parameterType", parameterType);
            params.put("parameterKey", parameterKey);
            List<BaseSystemParameter> list = baseSystemParameterRespository.getList(params);
            BaseSystemParameter b = (list == null || list.size() == 0) ? null : list.get(0);
            if (null != b) {
                synchronized (b) {
                    TYPEKEY_MAP.put(key, b);
                }
            }
            return b == null ? "" : b.getParameterValue();
        }
        return bsp.getParameterValue();
    }

    /**
     * 根据type 查询
     *
     * @param parameterType
     * @return
     */
    public List<BaseSystemParameter> getByType(String parameterType) {
        parameterType = StringUtils.trimToEmpty(parameterType);
        List<BaseSystemParameter> list = TYPE_MAP.get(parameterType);
        if (null == list || list.size() == 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parameterType", parameterType);
            List<BaseSystemParameter> results = baseSystemParameterRespository.getList(params);
            if (null != results && results.size() > 0) {
                synchronized (o) {
                    TYPE_MAP.put(parameterType, results);
                }
            }
            return results;
        }
        return list;
    }

    /**
     * 根据type 查询
     *
     * @param parameterType
     * @return
     */
    public List<Map> getMapByType(String parameterType) {
        parameterType = StringUtils.trimToEmpty(parameterType);
        List<BaseSystemParameter> list = TYPE_MAP.get(parameterType);
        List<Map> r = new ArrayList<>();
        if (null == list || list.size() == 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parameterType", parameterType);
            list = baseSystemParameterRespository.getList(params);
            if (null != list && list.size() > 0) {
                synchronized (o) {
                    TYPE_MAP.put(parameterType, list);
                }
            }
        }
        if (list != null) {
            for (BaseSystemParameter b : list) {
                Map m = new HashMap();
                m.put("parameterValue", b.getParameterValue());
                m.put("parameterName", b.getParameterName());
                m.put("parameterKey", b.getParameterKey());
                r.add(m);
            }
        }
        return r;
    }

    /**
     * 根据父key和类型查找
     *
     * @param pKey
     * @param type
     * @return
     */
    public List<BaseSystemParameter> getByPKeyAndType(String pKey, String type) {
        pKey = StringUtils.trimToEmpty(pKey);
        type = StringUtils.trimToEmpty(type);
        String key = pKey + CommonConstants.SEP_LINE + type;
        List<BaseSystemParameter> list = PKEY_MAP.get(key);
        if (null == list || list.size() == 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parentParameterKey", pKey);
            params.put("parameterType", type);
            List<BaseSystemParameter> results = baseSystemParameterRespository.getList(params);
            if (null != results && results.size() > 0) {
                synchronized (o) {
                    PKEY_MAP.put(key, results);
                }
            }
            return results;
        }
        return list;
    }

    public String create(BaseSystemParameter parameter) {
        String now = DateUtils.getNowStr(CommonConstants.DEFAULT_DATE_FORMAT);
        parameter.setRecId(idService.gen("read"));
        parameter.setAddTime(now);
        parameter.setUpdateTime(now);
        baseSystemParameterRespository.insert(parameter);
        return parameter.getRecId();
    }

    public BaseSystemParameter find(String recId) {
        return baseSystemParameterRespository.selectByPrimaryKey(recId);
    }


    public int count(BaseSystemParameter baseSystemParameter) {
        HashMap<String, Object> params = prepareSearchParam(baseSystemParameter);
        return baseSystemParameterRespository.count(params);
    }

    /**
     * 计算代码类型数量
     *
     * @param baseSystemParameter
     * @return
     */
    public int countType(BaseSystemParameter baseSystemParameter) {
        HashMap<String, Object> params = prepareSearchParam(baseSystemParameter);
        return baseSystemParameterRespository.countTypeV2(baseSystemParameter);
    }

    public List<BaseSystemParameter> getByPKeyAndPType(String pKey, String pType) {
        pKey = StringUtils.trimToEmpty(pKey);
        pType = StringUtils.trimToEmpty(pType);
        String key = pKey + CommonConstants.SEP_LINE + pType;
        List<BaseSystemParameter> list = PKEY_PTYPE_MAP.get(key);
        if (null == list || list.size() == 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parentParameterKey", pKey);
            params.put("parentParameterType", pType);
            List<BaseSystemParameter> results = baseSystemParameterRespository.getList(params);
            if (null != results && results.size() > 0) {
                synchronized (o) {
                    PKEY_PTYPE_MAP.put(key, results);
                }
            }
            return results;
        }
        return list;
    }


    /**
     * 获取指定类型字典的大小
     *
     * @param baseSystemParameter
     * @return
     */
    public int countTypeMapByType(BaseSystemParameter baseSystemParameter) {
        HashMap<String, Object> params = prepareSearchParam(baseSystemParameter);
        return baseSystemParameterRespository.countTypeMapByType(baseSystemParameter);
    }

    /**
     * v2按条件查询parameterType列表
     *
     * @param pageInfo
     * @param baseSystemParameter
     * @return
     */
    public List<BaseSystemParameterResult> listType(PageInfo pageInfo, BaseSystemParameter baseSystemParameter) {
        HashMap<String, Object> params = prepareSearchParam(baseSystemParameter);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return baseSystemParameterRespository.listTypeV2(params);
    }


    public void createAndRefreshMap(BaseSystemParameter parameter) {
        String now = DateUtils.getNowStr(CommonConstants.DEFAULT_DATE_FORMAT);
        parameter.setAddTime(now);
        parameter.setUpdateTime(now);
        baseSystemParameterRespository.insert(parameter);
        String pKey = StringUtils.trimToEmpty(parameter.getParentParameterKey());
        String pType = StringUtils.trimToEmpty(parameter.getParentParameterType());
        String key = pKey + CommonConstants.SEP_LINE + pType;
        List<BaseSystemParameter> brothers = PKEY_PTYPE_MAP.get(key);
        if (brothers != null) {
            brothers.add(parameter);
        }
        PKEY_PTYPE_MAP.put(key, brothers);
    }

    public void delete(String recId, String parameterKey, String parameterType) {
        BaseSystemParameter parameter = baseSystemParameterRespository.selectById(recId);
        baseSystemParameterRespository.deleteByPrimaryKey(recId);
        refreshPPMap(parameter);
    }

    public void refreshPPMap(BaseSystemParameter parameter) {
        String parameterKey = StringUtils.trimToEmpty(parameter.getParameterKey());
        String parameterType = StringUtils.trimToEmpty(parameter.getParentParameterType());
        String key = parameterKey + CommonConstants.SEP_LINE + parameterType;
        //如果parent不为null;1是子更新值：，2是父：直接删除键
        if (null != PKEY_PTYPE_MAP.get(key)) {
            PKEY_PTYPE_MAP.remove(key);
        } else {
            parameterKey = StringUtils.trimToEmpty(parameter.getParentParameterKey());
            parameterType = StringUtils.trimToEmpty(parameter.getParentParameterType());
            key = parameterKey + CommonConstants.SEP_LINE + parameterType;
            List<BaseSystemParameter> cList = PKEY_PTYPE_MAP.get(key);
            cList.remove(parameter);
            PKEY_PTYPE_MAP.put(key, cList);
        }
    }


    public void newUpdate(BaseSystemParameter parameter) {
        String now = DateUtils.getNowStr(CommonConstants.DEFAULT_DATE_FORMAT);
        parameter.setUpdateTime(now);
        baseSystemParameterRespository.updateByPrimaryKey(parameter);
        updatePPMap(parameter);
    }

    public void updatePPMap(BaseSystemParameter parameter) {
        String parameterKey = StringUtils.trimToEmpty(parameter.getParentParameterKey());
        String parameterType = StringUtils.trimToEmpty(parameter.getParentParameterType());
        String key = parameterKey + CommonConstants.SEP_LINE + parameterType;
        List<BaseSystemParameter> cList = PKEY_PTYPE_MAP.get(key);
        if (null == cList) {
            return;
        }
        Iterator<BaseSystemParameter> it = cList.iterator();
        while (it.hasNext()) {
            BaseSystemParameter x = it.next();
            if (x.getRecId().equals(parameter.getRecId())) {
                it.remove();
            }
        }
        cList.add(parameter);
        PKEY_PTYPE_MAP.put(key, cList);
    }


    /**
     * 按条件查询字典列表
     *
     * @param pageInfo
     * @param baseSystemParameter
     * @return
     */
    public List<BaseSystemParameter> list(BaseSystemParameter baseSystemParameter,PageInfo pageInfo) {
        HashMap<String, Object> params = prepareSearchParam(baseSystemParameter);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return baseSystemParameterRespository.list(params);
    }

    public int delete(String recId) {
        int result = baseSystemParameterRespository.deleteByPrimaryKey(recId);
        clear();
        return result;
    }

    public int update(BaseSystemParameter parameter) {
        String now = DateUtils.getNowStr(CommonConstants.DEFAULT_DATE_FORMAT);
        parameter.setUpdateTime(now);
        return baseSystemParameterRespository.updateByPrimaryKeySelective(parameter);
    }

    public void refresh() {
        init();
    }

    /**
     * 构建字典条件查询的条件列表
     *
     * @param baseSystemParameter
     * @return
     */
    private HashMap<String, Object> prepareSearchParam(BaseSystemParameter baseSystemParameter) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (baseSystemParameter != null) {
            if (baseSystemParameter.getParameterType() != null && !baseSystemParameter.getParameterType().trim().equals("")) {
                params.put("parameterType", baseSystemParameter.getParameterType().trim());
            }
            if (baseSystemParameter.getParameterKey() != null && !baseSystemParameter.getParameterKey().trim().equals("")) {
                params.put("parameterKey", baseSystemParameter.getParameterKey().trim());
            }
            if (baseSystemParameter.getParameterName() != null && !baseSystemParameter.getParameterName().trim().equals("")) {
                params.put("parameterName", "%" + baseSystemParameter.getParameterName().trim() + "%");
            }
            if (baseSystemParameter.getParentParameterType() != null && !baseSystemParameter.getParentParameterType().trim().equals("")) {
                params.put("parentParameterType", baseSystemParameter.getParentParameterType().trim());
            }
            if (baseSystemParameter.getParentParameterKey() != null && !baseSystemParameter.getParentParameterKey().trim().equals("")) {
                params.put("parentParameterKey", baseSystemParameter.getParentParameterKey().trim());
            }
        }
        return params;
    }

    /**
     * 根据参数类型、参数的值，查到这个具体的字典信息
     *
     * @param parameterType
     * @param parameterValue
     * @return
     */
    public BaseSystemParameter getBaseSystemParam(String parameterType, String parameterValue) {
        if (StringUtils.isEmpty(parameterType) || StringUtils.isEmpty(parameterValue)) {
            return null;
        }
        return baseSystemParameterRespository.selectByParamType_Value(parameterType, parameterValue);
    }


    public Boolean validateValueAndType(BaseSystemParameter parameter) {
        HashMap<String, Object> params = new HashMap<>();
        if (parameter.getParameterType() != null && !parameter.getParameterType().trim().equals("")) {
            params.put("parameterType", parameter.getParameterType().trim());
        } else {
            return false;
        }
        if (parameter.getParameterKey() != null && !parameter.getParameterKey().trim().equals("")) {
            params.put("parameterKey", parameter.getParameterKey().trim());
        } else {
            params.put("parameterKey", null);
        }
        if (parameter.getParameterValue() != null && !parameter.getParameterValue().trim().equals("")) {
            params.put("parameterValue", parameter.getParameterValue().trim());
        } else {
            params.put("parameterValue", null);
        }

        List<BaseSystemParameter> list = baseSystemParameterRespository.validateValueAndType(params);
        if (list != null && list.size() > 0) {
            if (list.get(0).getWeight() != parameter.getWeight()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public Integer batchCreate(List<BaseSystemParameter> parameter) {
        parameter.stream().map(
                param -> {
                    if (validateValueAndType(param)) {
                        BaseSystemParameter byKeyAndType = getByKeyAndType(param.getParameterType(), param.getParameterKey());
                        if (null == byKeyAndType) {
                            create(param);
                        } else {
                            param.setRecId(byKeyAndType.getRecId());
                            update(param);
                        }
                    } else {
                        //do nothing
                    }
                    return param;
                }
        ).collect(Collectors.toList());
        return 1;
    }

    public void clear() {
        PKEY_PTYPE_MAP.clear();
        TYPE_MAP.clear();
        PKEY_MAP.clear();
        PKEY_PTYPE_MAP.clear();
        TYPEKEY_MAP.clear();
        VALUE_MAP.clear();
    }
}
