package com.synapse.reading.respository;

import com.synapse.reading.mapper.RecommendMapper;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.Directories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 推荐 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface RecommendRespository extends RecommendMapper {
    List<Book> selectByRecommendType(@Param("recommendType")String recommendType);

    List<Directories> selectByRecommend(@Param("recommendType")String recommendType);
}
