package com.synapse.reading.respository;

import com.synapse.reading.dto.result.MemberResult;
import com.synapse.reading.mapper.MemberMapper;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
public interface MemberRespository extends MemberMapper {

   List<Map<String,String>> countTeacherNum (Map<String, Object> params);

    Integer countTeacherBySchool(Map<String, Object> params);

    List<MemberResult> listByShchool(Map<String, Object> params);

    Integer addPoint(Member member);

    public List<Member> selectByIdCard(@Param("idCard") String idCard);

    Member selectByUserId(String userId);

    String selectByPhone(String phone);

    List<Member> selectExpert(Map<String, Object> params);

    Integer countTeacher(String roleId);

    Integer countClassMember(String classId);

    List<MemberResult> listByClassId(Map<String, Object> params);

    List<Member> listTeacher(Map<String, Object> params);

    List<MemberResult> listMember( Map<String,String> map);

    List<Member> listByTaskId(@Param("taskId") String taskId);
}
