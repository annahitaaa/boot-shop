package com.annahita.bootshop.controller;

import com.annahita.bootshop.entity.Employee;
import com.annahita.bootshop.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test","done");
        httpHeaders.add(httpHeaders.CONTENT_LOCATION, "iran");

        ResponseEntity<Page<Employee>> response = new ResponseEntity<Page<Employee>>(employees, httpHeaders, HttpStatus.OK);
        return response;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

}
