package com.synapse.reading.mapper;

import com.synapse.reading.model.Section;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 章节 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
public interface SectionMapper {
    Section selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Section model);

    void insertSelective(Section model);

    Integer updateByPrimaryKeySelective(Section model);

    Integer updateByPrimaryKey(Section model);

    List<Section> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
