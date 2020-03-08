package com.course.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerUiConfig {

    // 配置swagger2核心配置 docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)    // 指定api类型为swagger2
        .apiInfo(apiInfo())  // 用于定义api文档汇总信息
        .select()
        .paths(PathSelectors.regex("/.*"))  //正则匹配所有路径网址
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("我的接口文档")
                .contact(new Contact("xxx","","yyy@zzz.com"))
                .description("这是swaggerui生成的接口文档")
                .version("1.0.0.0")
                .build();
    }
}
