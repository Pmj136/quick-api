package com.pmj.api.util;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author 彭明久
 * @since 2021-03-19
 */
public class MailUtil {

    private static JavaMailSender javaMailSender;

    private static MailProperties mailProperties;

    public static void init(JavaMailSender javaMailSender,
                            MailProperties mailProperties) {
        MailUtil.javaMailSender = javaMailSender;
        MailUtil.mailProperties = mailProperties;
    }

    /*发送邮件*/
    public static void send(String source, String text, String target) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setSubject(source);
        smm.setText(text);
        smm.setFrom(mailProperties.getUsername());
        smm.setTo(target);
        javaMailSender.send(smm);
    }
}
