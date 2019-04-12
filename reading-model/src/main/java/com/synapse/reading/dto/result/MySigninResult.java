package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.MySignin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MySigninResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@ApiModel(value = "MySigninResult对象", description = "我的签到")
public class MySigninResult {

    private MySignin mySignin = new MySignin();

    public MySigninResult() {
    }

    public MySigninResult(MySignin mySignin) {
        if (mySignin != null) {
            this.mySignin = mySignin;
        }
    }

    @JsonIgnore
    public MySignin getModel() {
        return mySignin;
    }

    public void setModel(MySignin mySignin) {
        this.mySignin = mySignin;
    }

    @ApiModelProperty(value = "主键")
    public String getRecId() {
        return mySignin.getRecId();
    }

    public void setRecId(String rec_id) {
        mySignin.setRecId(rec_id);
    }

    @ApiModelProperty(value = "签到获得的积分")
    public Integer getPoint() {
        return mySignin.getPoint();
    }

    public void setPoint(Integer point) {
        mySignin.setPoint(point);
    }

    @ApiModelProperty(value = "签到人")
    public String getCreateId() {
        return mySignin.getCreateId();
    }

    public void setCreateId(String create_id) {
        mySignin.setCreateId(create_id);
    }

    @ApiModelProperty(value = "签到时间")
    public String getCreateTime() {
        return mySignin.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        mySignin.setCreateTime(create_time);
    }


}
