package edu.snnu.startyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication(scanBasePackages="edu.snnu.startyun")
@MapperScan(basePackages = "edu.snnu.startyun.dao")
public class StarYunApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarYunApplication.class, args);
    }
}
