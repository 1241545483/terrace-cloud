package com.synapse.reading.mapper;

import com.synapse.reading.model.Category;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 推荐中高考书籍目录（三级） Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
public interface CategoryMapper {
    Category selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Category model);

    void insertSelective(Category model);

    Integer updateByPrimaryKeySelective(Category model);

    Integer updateByPrimaryKey(Category model);

    List<Category> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
