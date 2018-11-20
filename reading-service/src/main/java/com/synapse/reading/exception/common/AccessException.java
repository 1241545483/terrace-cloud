package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "没有权限！")
public class AccessException extends BusinessException {

    private final static int CODE = 403;

    public AccessException() {
        super(CODE, "没有权限！");
    }

    public AccessException(int code, String msg) {
        super(code, msg);
    }
}
