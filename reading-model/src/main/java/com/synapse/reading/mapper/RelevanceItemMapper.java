package com.synapse.reading.mapper;

import com.synapse.reading.model.RelevanceItem;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 书籍与目录对应关系 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-23
 */
public interface RelevanceItemMapper {
    RelevanceItem selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(RelevanceItem model);

    void insertSelective(RelevanceItem model);

    Integer updateByPrimaryKeySelective(RelevanceItem model);

    Integer updateByPrimaryKey(RelevanceItem model);

    List<RelevanceItem> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
