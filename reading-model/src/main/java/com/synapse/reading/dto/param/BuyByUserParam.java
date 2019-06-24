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
@ApiModel(value = "buyByUserParam对象", description = "是否购买参数")
public class BuyByUserParam {

    private  String studyId;
    private  String studyType;

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }
}
