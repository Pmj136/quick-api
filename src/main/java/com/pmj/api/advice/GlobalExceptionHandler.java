package com.pmj.api.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获
 *
 * @author 彭明久
 * @since 2021-03-19
 */
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public void handleAllPointerExp(Exception e) {
        System.out.println(e.getMessage());
    }
}
