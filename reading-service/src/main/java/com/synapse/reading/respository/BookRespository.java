package com.synapse.reading.respository;

import com.synapse.reading.dto.result.AudioResult;
import com.synapse.reading.dto.result.BookResult;
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
    List<BookResult> listMyCollectByBook(@Param("userId") String userId);

    BookResult selectIsCollect(@Param("userId") String userId,@Param("recId") String recId);
}
