package com.mybatiscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * MybatisCacheApplication Class
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
@SpringBootApplication
@MapperScan("com.mybatiscache.dao")
public class MybatisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisCacheApplication.class, args);
    }

}
