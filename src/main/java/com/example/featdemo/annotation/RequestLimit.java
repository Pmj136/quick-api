package com.example.featdemo.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimit {
    int limit() default 1;
    long timeout() default 3;
}
