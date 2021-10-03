package com.example.featdemo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Result implements Serializable {
    private Integer error;
    private Object data;
    private String msg;

    public static Result resolve() {
        return new Result(0, null, "success");
    }

    public static Result resolve(Object data) {
        return new Result(0, data, "success");
    }

    public static Result resolve(Object data, String msg) {
        return new Result(0, data, msg);
    }

    public static Result reject(String msg) {
        return new Result(1000, null, msg);
    }

    public static Result AuthError(Integer error, String msg) {
        return new Result(error, null, msg);
    }

    public static Result AuthError(String msg) {
        return new Result(2000, null, msg);
    }

    public static Result AuthError() {
        return new Result(2000, null, "用户验证失败，请重新登录");
    }

    public static Result build(Integer code, Object data, String msg) {
        return new Result(code, data, msg);
    }
}