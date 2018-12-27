package com.synapse.reading.respository;

import com.synapse.reading.mapper.BookMapper;
import com.synapse.reading.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface BookRespository extends BookMapper {
    List<Book> selectByRecommendType(@Param("recommendtType")String recommendtType);
}
