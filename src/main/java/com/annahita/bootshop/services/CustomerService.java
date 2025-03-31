package com.annahita.bootshop.services;


import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(CustomerDto customerDto);
    void update(CustomerDto customerDto);
    void deleteById(Long customerId);

    Customer findById(Long customerId);
}
