package com.example.demo.business.service.concretes;

import com.example.demo.business.dto.EmployeeDto;
import com.example.demo.business.service.abstracts.IEmployeeService;
import com.example.demo.data.entity.concretes.EmployeeEntity;
import com.example.demo.data.repository.IEmployeeRepository;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log4j2

@Service
@Transactional
public class EmployeeService implements IEmployeeService {


    private IEmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    //MODEL MAPPER

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }

    //MODEL MAPPER
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        modelMapper = new ModelMapper();
        EmployeeDto employeeDto = modelMapper.map(employeeEntity,EmployeeDto.class);
        return  employeeDto;
    }

    //SAVE
    @PostMapping("/save/employee")
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        if(employeeDto!=null){
                EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
                employeeRepository.save(employeeEntity);
        }
        return employeeDto;
    }
    //LIST
    @GetMapping("/list/employee")
    @Override
    public List<EmployeeDto> getAllEmployee() {
       List<EmployeeEntity> employeeEntityList = (List<EmployeeEntity>) employeeRepository.findAll();
       List<EmployeeDto> employeeDtoList = new ArrayList<>();
       for(EmployeeEntity temp:employeeEntityList){
           employeeDtoList.add(entityToDto(temp));
       }
       return employeeDtoList;
    }

    //FIND
    @GetMapping("/find/employee/{id}")
    @Override
    public EmployeeDto findEmployee(@PathVariable Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"is not found!"));
        EmployeeDto employeeDto =entityToDto(employeeEntity);
        return employeeDto;
    }
    // UPDATE
    @PutMapping("/update/employee/{id}")
    @Override
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if(employeeDto!= null){
            EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow();
            employeeEntity.setName(employeeDto.getName());
            employeeEntity.setSurname(employeeDto.getSurname());
        }
        return employeeDto;
    }
    //DELETE
    @DeleteMapping("/delete/employee/{id}")
    @Override
    public Map<String, Boolean> deleteEmployee(@PathVariable Long id) {
        Map<String,Boolean> map = new HashMap<>();
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeEntity);
        if (employeeEntity!=null){
            map.put("Not Deleted",false);
        }
        map.put("Deleted",true);
        return map;
    }
}
