package com.example.featdemo;

import com.example.featdemo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class FeatDemoApplicationTests {
    @Test
    void contextLoads() {
        RedisUtil.set("name2","111");
    }
}
