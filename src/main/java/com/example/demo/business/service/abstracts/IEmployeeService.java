package com.example.demo.business.service.abstracts;

import com.example.demo.business.dto.EmployeeDto;
import com.example.demo.data.entity.concretes.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    //MODEL MAPPER
     EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
     EmployeeDto entityToDto(EmployeeEntity employeeEntity);

    //SAVE
     EmployeeDto createEmployee(EmployeeDto employeeDto);
    //LIST
     List<EmployeeDto> getAllEmployee();
    //FIND
     EmployeeDto findEmployee(Long id);
    //UPDATE
     EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    //DELETE
     Map<String,Boolean> deleteEmployee(Long id);









}
