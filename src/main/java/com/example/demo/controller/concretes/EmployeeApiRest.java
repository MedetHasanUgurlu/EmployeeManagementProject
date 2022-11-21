package com.example.demo.controller.concretes;

import com.example.demo.business.dto.EmployeeDto;
import com.example.demo.business.service.abstracts.IEmployeeService;
import com.example.demo.controller.abstracts.IEmployeeApiRest;
import com.example.demo.error.ApiResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/employee/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeApiRest implements IEmployeeApiRest {
    private final IEmployeeService service;


    @Autowired
    public EmployeeApiRest(IEmployeeService service) {
        this.service = service;
    }

    //SPEED DATA
    //http://localhost:8080/employee/api/v1/index
    @GetMapping({"/","index"})
    @Override
    public String getRoot() {
        return "index";
    }

    //SAVE
    //http://localhost:8080/employee/api/v1/employee
    @Override
    @PostMapping("/employee")
    public ResponseEntity<ApiResult> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        String path = "http://localhost:8080/employee/api/v1/employee";
        service.createEmployee(employeeDto);
        ApiResult apiResult = new ApiResult(200,path,"Created");
       //ApiResult apiResult =service.findEmployee(employeeDto.getId())!= null? new ApiResult(200,path,"Created"):new ApiResult(400,path,"not created");
        return ResponseEntity.ok(apiResult);
    }

    //LIST
    //http://localhost:8080/employee/api/v1/employees
    @Override
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employeeDtoList = service.getAllEmployee();
        return  ResponseEntity.ok(employeeDtoList);
    }

    //FIND
    //http://localhost:8080/employee/api/v1/employee/2
    @Override
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findEmployee(id));
    }

    //DELETE
    //http://localhost:8080/employee/api/v1/employee/2
    @Override
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) {
        service.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",true);
        return ResponseEntity.ok(response);
    }

    //UPDATE
    //http://localhost:8080/employee/api/v1/employee/2
    @Override
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id")Long id, @RequestBody EmployeeDto employeeDto) {
        service.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto);
    }
}
