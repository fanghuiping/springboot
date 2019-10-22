package com.shangke.springcoller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Component
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.shangke.springcoller.conller")).build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人姓名", "https://4399.com", "kkry@100.com");
        return new ApiInfo("Swagger学习", "学习演示如何配置Swagger", "v1.0",
                "http://4399.com", contact, "Appch2.0许可", "许可链接",new ArrayList<>());
    }
}
