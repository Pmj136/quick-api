package com.example.featdemo.exception;

/**
 * 接口请求次数异常
 */
public class LimitRequestException extends Throwable {
    public LimitRequestException(String message) {
        super(message);
    }
}
