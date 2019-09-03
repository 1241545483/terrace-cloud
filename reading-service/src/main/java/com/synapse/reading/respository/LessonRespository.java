package com.synapse.reading.respository;

import com.synapse.reading.dto.param.OrderNumParam;
import com.synapse.reading.dto.result.AudioResult;
import com.synapse.reading.dto.result.BookResult;
import com.synapse.reading.dto.result.LessonResult;
import com.synapse.reading.mapper.LessonMapper;
import com.synapse.reading.model.Expert;
import com.synapse.reading.model.Lesson;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 课程 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
public interface LessonRespository extends LessonMapper {

    List<Lesson> listLessonByOrg(Map<String, Object> params);
    List<Lesson> listByLessonIds(@Param("lessonIds")List<String> lessonIds);
    Integer countListLessonByOrg(Map<String, Object> params);
    List<Lesson> listLessonByMyself(Map<String, Object> params);
    Integer countListLessonByMyself(Map<String, Object> params);
    Integer lessonBuy(Map<String, Object> params);
    Integer  addNum(@Param("recId") String recId);
    List<Lesson> listbyexpertLessons(@Param("expertId")String expertId);
    List<Lesson> listbyexpertAll(Map<String, Object> params);
    Integer countListbyexpertAll(@Param("expertId")String expertId);
    Integer updateByorderNum(@Param("orderNumParam")OrderNumParam orderNumParam);
    LessonResult selectIsCollect(@Param("userId") String userId,@Param("recId") String recId);
    List<Lesson> listradeOrderProdId(Map<String, Object> params);
    List<LessonResult> listMyCollectByLesson(@Param("userId") String userId);

    int countListWithVideoNum();

    List<LessonResult> listWithVidwoNum(Map<String, Object> params);
}
