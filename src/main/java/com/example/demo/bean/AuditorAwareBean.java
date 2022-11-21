package com.example.demo.bean;

import com.example.demo.audit.AuditorAwareImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {
    @Bean
    public AuditorAware auditorAwareBeanMethod(){
        return new AuditorAwareImp();
    }
}
