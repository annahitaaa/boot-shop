package com.annahita.bootshop.services;

import com.annahita.bootshop.entity.Customer;
import com.annahita.bootshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Transactional
    @Modifying
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Modifying
    @Override
    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer findById(Long customerId) {
       return customerRepository.findById(customerId).orElseThrow(()-> new RuntimeException("Customer not found"));
    }
}
