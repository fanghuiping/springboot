package com.spring.springbootmybatismutipledatasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@Configuration
//@ComponentScan(basePackages = {"com.spring.springbootmybatismutipledatasource.conller"})
public class swagger2 {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("方慧平", "www.4399.com", "kkry@qq.com");
        return new ApiInfoBuilder()
                .title("SpringBoot+mybatis多数据源配置")
                .description("空")
                .contact(contact)
                .version("1.0.0")
                .build();
    }
}
