package com.annahita.bootshop.services;


import com.annahita.bootshop.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);
}
