package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;

public class CreateJobFailException extends BusinessException {
    private final static int CODE = 1008;

    public CreateJobFailException(String msg) {
        super(CODE, msg);
    }

    public CreateJobFailException() {
        super(CODE, "创建Job失败！");
    }
}
