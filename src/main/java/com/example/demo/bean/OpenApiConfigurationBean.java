package com.example.demo.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigurationBean {
    @Bean
    public OpenAPI OpenApiMethod(){
        return new OpenAPI()
                .info(new Info().title("Title").description("Tanımlama").version("v1.0")
                        .contact(new Contact().name("Free Bus Doctor").url("https//www.mhu.com.tr").email("mdt.hsn.76@hotmail.com"))
                        .termsOfService("INC BY")
                        .license(new License().name("V21-ASCA"))
        );
    }
}
