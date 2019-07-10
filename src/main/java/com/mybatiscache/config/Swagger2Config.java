package com.mybatiscache.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/***
 * Swagger2Config class
 *
 * @author yuxiang
 * @date 2019/5/10
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket myDocket(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo=new ApiInfo("RESTFUL APIs",
                "数据库二级缓存配置第三方缓存以及乐观锁测试",
                "1.0",
                "apiDocs",
                "106957264@qq.com",
                "",
                "");
        docket.apiInfo(apiInfo);
        return docket;
    }
}
