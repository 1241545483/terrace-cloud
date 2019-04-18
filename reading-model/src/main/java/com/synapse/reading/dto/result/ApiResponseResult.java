package com.synapse.reading.dto.result;

/**
 * api调用返回结果实体类
 *
 * Created by huwei on 2017/11/13.
 */
public class ApiResponseResult<T> {

    private String responseCode;

    private String responseDesc;

    private T data;

    public ApiResponseResult() {}

    public ApiResponseResult(String responseCode, String responseDesc, T data) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        this.data = data;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
