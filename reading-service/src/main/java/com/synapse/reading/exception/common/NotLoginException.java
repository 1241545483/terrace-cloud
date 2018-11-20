package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;

/**
 * 未登录
 */
public class NotLoginException extends BusinessException {

    private final static int CODE = 1001;

    public NotLoginException(String msg) {
        super(CODE, msg);
    }

    public NotLoginException() {
        super(CODE, "未登录！");
    }
}
