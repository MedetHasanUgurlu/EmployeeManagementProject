package com.example.demo.data.repository;

import com.example.demo.data.entity.concretes.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<EmployeeEntity,Long> {




    EmployeeEntity findByEmail(String email);
}
