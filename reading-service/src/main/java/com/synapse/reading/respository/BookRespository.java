package com.synapse.reading.respository;

import com.synapse.reading.dto.result.AudioResult;
import com.synapse.reading.dto.result.BookResult;
import com.synapse.reading.mapper.BookMapper;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /*
    修改书籍为发布状态
     */
    Integer bookPublished(@Param("recId") String recId);

    /*
    修改书籍为未发布状态
    */
    Integer bookUnPublished(@Param("recId") String recId);

    List<Book> listByBookIds(@Param("bookIds")List<String> bookIds);

    List<Book> listradeOrderProdIdBooks(Map<String, Object> params);


}
