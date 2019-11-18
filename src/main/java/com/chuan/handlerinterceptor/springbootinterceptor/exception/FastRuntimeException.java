package com.chuan.handlerinterceptor.springbootinterceptor.exception;

import lombok.Data;

@Data
public class FastRuntimeException extends RuntimeException {

    private Integer code;
    private String msg;

    public FastRuntimeException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String toString() {
        return "SaasBaseException(code=" + this.getCode() + ", msg=" + this.getMsg() + ")";
    }
}
