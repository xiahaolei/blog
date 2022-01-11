package com.xiahl.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 15:42
 * @Desc
 */
@SpringBootApplication(scanBasePackages = {"com.xiahl.blog"})
@MapperScan("com.xiahl.blog.repository")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
