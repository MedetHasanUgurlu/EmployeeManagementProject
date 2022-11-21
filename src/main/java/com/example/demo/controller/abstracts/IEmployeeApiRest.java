package com.example.demo.controller.abstracts;

import com.example.demo.business.dto.EmployeeDto;
import com.example.demo.error.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Map;

public interface IEmployeeApiRest {
    //SPEED DATA
    public String getRoot();

    //SAVE
    public ResponseEntity<ApiResult> createEmployee(EmployeeDto employeeDto);

    //LIST
    public ResponseEntity<List<EmployeeDto>> getEmployees();

    //FIND
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //DELETE
     public ResponseEntity<Map<String, Boolean>>  deleteEmployee(Long id);

    //UPDATE
    public ResponseEntity<EmployeeDto> updateEmployee(Long id,EmployeeDto employeeDto);

}
