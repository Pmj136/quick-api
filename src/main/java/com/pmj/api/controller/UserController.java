package com.pmj.api.controller;


import com.pmj.api.util.CaptchaUtil;
import com.pmj.api.util.CookieUtil;
import com.pmj.api.util.RedisUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 彭明久
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/captcha")
    public void captcha(HttpServletRequest request) {
        CaptchaUtil.generate();

        String sessionCode = (String) request.getSession().getAttribute("captcha");
        System.out.println(sessionCode);
    }


    @PostMapping("/cookie")
    public void cookie() {
        CookieUtil.set("name", "2345");
    }

    @PostMapping("/cookie/get")
    public void cookieg() {
        System.out.println(CookieUtil.get("name"));
    }

    @PostMapping("/redis")
    public void redis() {
        RedisUtil.set("token", "1111");
        System.out.println(RedisUtil.isExpire("token"));
    }
}

