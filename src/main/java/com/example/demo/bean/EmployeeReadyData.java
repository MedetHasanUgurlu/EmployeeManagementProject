package com.example.demo.bean;

import com.example.demo.business.dto.EmployeeDto;
import com.example.demo.business.service.concretes.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class EmployeeReadyData {

    @Bean
    CommandLineRunner createEmployeeData(EmployeeService service){
        return (x)->{
            for (int i = 1; i < 15 ; i++) {
                UUID uuid = UUID.randomUUID();
                EmployeeDto employeeDto = EmployeeDto.builder().name("name"+i).surname("surname"+i).email("hotmail1"+i+"@hotmail.com").password("password"+i).build();
                service.createEmployee(employeeDto);
            }
        };
    }
}
