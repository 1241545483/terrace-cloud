package com.synapse.reading.mapper;

import com.synapse.reading.model.Book;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
public interface BookMapper {
    Book selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Book model);

    void insertSelective(Book model);

    Integer updateByPrimaryKeySelective(Book model);

    Integer updateByPrimaryKey(Book model);

    List<Book> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
