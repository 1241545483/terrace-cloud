package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;

public class QuartzCronException extends BusinessException {
    private final static int CODE = 1009;

    public QuartzCronException(String msg) {
        super(CODE, msg);
    }

    public QuartzCronException() {
        super(CODE, "QuartzCron表达式错误！");
    }
}
