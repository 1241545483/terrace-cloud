package com.synapse.reading.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    private static Logger logger = LoggerFactory.getLogger(Converter.class);

    /**
     * 转换为 modelList
     *
     * @param sourceList
     * @return
     */
    public static <T, E> List<E> convert(List<T> sourceList, Class<E> targetClz) {
        if (null == sourceList || sourceList.size() == 0) {
            return null;
        }
        int osSize = sourceList.size();
        List<E> ds = new ArrayList<E>(osSize);
        for (int i = 0; i < osSize; i++) {
            ds.add(convert(sourceList.get(i), targetClz));
        }
        return ds;
    }

    /**
     * 转换为model
     *
     * @param source
     * @param targetClz
     * @return
     */
    public static <T, E> E convert(T source, Class<E> targetClz) {
        if (null == source) {
            return null;
        }
        Object target;
        try {
            target = targetClz.newInstance();
            copyPropertis(source, target);
            return (E) target;
        } catch (Exception e) {
            logger.error("convert Error", e);
            return null;
        }
    }

    //对于主键，从后台获取后，到前台需要加密
    //同前台传递到后台，需要解密
    //前台为String，后台为Long，字段名不变

    //对于字典字段，比如状态，类型等
    //前台有Txt结尾的字段，为对应状态的文本，例如statusTxt,typeTxt

    //对于下拉选择，通过Dict注解标注，获取对应的key/value对列表，字段以Dict结尾的列表
    //waring!!!注意，目前实现只支持extends一次！
    public static void copyPropertis(Object source, Object target) {
        Class sourceClz = source.getClass();
        List<Field> sourceFieldList = new ArrayList<>();
        if (sourceClz.getSuperclass() != Object.class) {
            //有父类,获取父类的所有字段
            Field[] superSourceFields = sourceClz.getSuperclass().getDeclaredFields();
            sourceFieldList.addAll(Arrays.asList(superSourceFields));
        }
        Field[] sourceFields = sourceClz.getDeclaredFields();
        sourceFieldList.addAll(Arrays.asList(sourceFields));
        Class targetClz = target.getClass();
        try {
            for (Field sourceField : sourceFieldList) {
                try {
                    String fieldName = sourceField.getName();
                    Class sourceFieldType = sourceField.getType();
                    Field targetField;
                    try {
                        targetField = targetClz.getDeclaredField(fieldName);
                    } catch (Exception e) {
                        targetField = targetClz.getSuperclass().getDeclaredField(fieldName);
                    }
                    Class targetFieldType = targetField.getType();
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    Object sourceVal = sourceField.get(source);

                    if (sourceVal == null) continue;
                    //默认直接拷贝
                    targetField.set(target, sourceField.get(source));
                } catch (NoSuchFieldException e) {
                    continue;
                }
            }
        } catch (Exception e) {
        	logger.error("copyPropertis error",e);
        }
    }
}
