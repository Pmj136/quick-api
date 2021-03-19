package com.pmj.api;

import com.pmj.api.util.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author 彭明久
 * @since 2021-03-18
 */
@SpringBootTest
public class MailTest {


    @Test
    void sendMail() {
        MailUtil.send("test", "你的验证码", "1367559786@qq.com");
    }
}
