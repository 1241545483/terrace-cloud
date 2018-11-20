package com.synapse.reading.web.formatter;

import com.synapse.common.formatter.DictFormatter;
import com.synapse.common.web.SpringContextUtils;
import com.synapse.reading.service.BaseSystemParameterService;

/**
 * Created by wangyifan on 18-5-3.
 */
public class ShiluDictFormatter implements DictFormatter {

    @Override
    public String findDictText(Object code, String type) {
        return fetchDictText(code, type);
    }

    @Override
    public Object findDict(String type) {
        return fetchDict(type);
    }


    /**
     * 根据Dict注解中的value值获取字典列表
     *
     * @param value
     * @return
     */
    private Object fetchDict(String value) {
        if (null != value && value.length() > 0) {
            BaseSystemParameterService bsps = SpringContextUtils.getBean("baseSystemParameterService");
            return bsps.getMapByType(value);
        }
        return null;
    }

    private static final String SPLITER = ",";

    /**
     * 根据实际的值获取对应的字典value
     *
     * @param key
     * @return
     */
    private String fetchDictText(Object key, String type) {
        if (key == null) return "";
        String k = key + "";
        if (k.contains(SPLITER)) {
            //如果是逗号隔开的字符串，则分隔开查询，再合并
            String[] splitedKeys = k.split(SPLITER);
            StringBuffer result = new StringBuffer();
            for (String sk : splitedKeys) {
                result.append(findDictText(sk, type));
                result.append(SPLITER);
            }
            return result.substring(0, result.length() - 1);
        }
        if (key != null) {
            BaseSystemParameterService bsps = SpringContextUtils.getBean("baseSystemParameterService");
            return bsps.getValueByKeyAndType(type, "" + key);
        }
        return "";
    }
}
