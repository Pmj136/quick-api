package com.pmj.api.config;

import com.pmj.api.util.CaptchaUtil;
import com.pmj.api.util.CookieUtil;
import com.pmj.api.util.MailUtil;
import com.pmj.api.util.RedisUtil;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 彭明久
 * @since 2021-03-19
 */
@Configuration
public class UtilConfig {
    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private MailProperties mailProperties;

    @Bean
    public void initUtil() {
        CaptchaUtil.init(request, response);
        CookieUtil.init(request, response);
        RedisUtil.init(redisTemplate);
        MailUtil.init(javaMailSender, mailProperties);
    }
}
