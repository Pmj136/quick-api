package com.example.featdemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.example.featdemo.base.BaseServiceImpl;
import com.example.featdemo.base.IBaseService;

import java.util.Collections;

public class FastAutoGeneratorTest {
    private final static String url = "jdbc:mysql://localhost:3306/jju_assistant?useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai";
    private final static String username = "root";
    private final static String password = "123456";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("彭明久") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride()
                            .disableOpenDir()
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.featdemo") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableRestStyle();
//                    builder.mapperBuilder().enableMapperAnnotation();

                    builder.serviceBuilder()
                            .superServiceClass(IBaseService.class)
                            .superServiceImplClass(BaseServiceImpl.class);
//                    builder.addInclude()// 设置需要生成的表名
//                            .addExclude()
//                            .addTablePrefix("sys_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
