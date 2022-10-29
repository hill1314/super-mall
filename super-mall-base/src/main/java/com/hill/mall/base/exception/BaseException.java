package com.hill.mall.base.exception;

import com.hill.mall.base.BaseResult;

/**
 * BaseException
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public String code;
    public String message;

    public BaseException(BaseResult baseResult) {
        super(String.format("[%s] %s", baseResult.getCode(), baseResult.getMessage()));
        this.code = baseResult.getCode();
        this.message = baseResult.getMessage();
    }

    public BaseException(Throwable e) {
        super(e);
        this.code = "-1";
        this.message = e.getMessage();
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public BaseException(String code, String message) {
        super(String.format("[%s] %s", code, message));
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, Throwable e) {
        super(String.format("[%s] %s", code, message), e);
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
