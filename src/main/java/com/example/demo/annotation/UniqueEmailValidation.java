package com.example.demo.annotation;

import com.example.demo.data.entity.concretes.EmployeeEntity;
import com.example.demo.data.repository.IEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    public UniqueEmailValidation(IEmployeeRepository repository) {
        this.repository = repository;
    }

    private IEmployeeRepository repository;



    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        EmployeeEntity employeeEntity=repository.findByEmail(email);
        //eğer bu emailimizi database varsa
        if(employeeEntity!=null){
            return false;
        }
        return true;
    }
}
