package com.annahita.bootshop.controller;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import com.annahita.bootshop.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Page<Customer>> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test","done");
        httpHeaders.add(httpHeaders.CONTENT_LOCATION, "iran");

        ResponseEntity<Page<Customer>> response = new ResponseEntity<Page<Customer>>(customers, httpHeaders, HttpStatus.OK);
        return response;
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.update(customerDto);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId){
        try{
            Customer customer = customerService.findById(customerId);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found",e);
        }


        customerService.deleteById(customerId);
        return ResponseEntity.ok("customer deleted successfully");
    }

}
