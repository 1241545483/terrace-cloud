package com.synapse.reading.service;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供公共方法
 */
public class BaseService {

    public Map<String, Object> prepareParams(Object param) {
        BeanMap beanMap = BeanMap.create(param);
        Map<String, Object> map = new HashMap<>();
        for (Object key : beanMap.keySet()) {
            map.put(key + "", beanMap.get(key));
        }
        return map;
    }
}
