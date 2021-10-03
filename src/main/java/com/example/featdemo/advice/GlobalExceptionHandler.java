package com.example.featdemo.advice;

import com.example.featdemo.exception.LimitRequestException;
import com.example.featdemo.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public void handleLimitExp(Exception e) {
        System.out.println("capture");
    }

    @ExceptionHandler({LimitRequestException.class})
    public Result handleLimitExp(LimitRequestException e) {
        return Result.reject(e.getMessage());
    }
}
