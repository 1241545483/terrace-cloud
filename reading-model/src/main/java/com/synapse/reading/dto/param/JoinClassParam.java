package com.synapse.reading.dto.param;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * ClassInfoParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "JoinClassParam对象", description = "加入班级参数")
public class JoinClassParam {
    private  String classCode;
    private  String studentId;
    private  String realName;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
