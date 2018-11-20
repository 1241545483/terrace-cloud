package com.synapse.reading.respository;

import com.synapse.reading.dto.result.BaseSystemParameterResult;
import com.synapse.reading.mapper.BaseSystemParameterMapper;
import com.synapse.reading.model.BaseSystemParameter;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseSystemParameterRespository extends BaseSystemParameterMapper{
	
	List<BaseSystemParameter> getList(Map<String, Object> map);

	List<BaseSystemParameter> list(HashMap<String, Object> params);

	BaseSystemParameter selectByParamType_Value(@Param("parameterType") String parameterType, @Param("parameterValue") String parameterValue);

	List<Map<String, String>> superManagerSelect(String sql);

	int superManagerUpdate(String sql);

	int superManagerDelete(String sql);
	void insertAndGet(BaseSystemParameter baseSystemParameter);
	int countType(BaseSystemParameter baseSystemParameter);
	//查询BaseSystemParameter
	List<BaseSystemParameterResult> listType(HashMap<String, Object> params);

	int countTypeMapByType(BaseSystemParameter baseSystemParameter);

	BaseSystemParameter selectById(@Param("recId") String recId);

	List<BaseSystemParameter> validateValueAndType(HashMap<String, Object> params);

	List<BaseSystemParameterResult> getAll(Map<String, Object> params);

    BaseSystemParameterResult selectByParamType_Key(Map<String, Object> params);

	Integer getTopKeyByType(HashMap<String, Object> objectObjectHashMap);

	List<BaseSystemParameterResult> listTypeV2(HashMap<String, Object> params);

	int countTypeV2(BaseSystemParameter baseSystemParameter);
}
