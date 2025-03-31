package com.annahita.bootshop.services;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Authority;
import com.annahita.bootshop.entity.Customer;
import com.annahita.bootshop.entity.User;
import com.annahita.bootshop.mapper.CustomerMapper;
import com.annahita.bootshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final List<String> NEW_CUSTOMER_AUTHORITIES = List.of(
            "add-cart", "update-customer", "delete-cart", "update-cart"
    );

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AuthorityService authorityService;
    private PasswordEncoder passwordEncoder;


    @Transactional(readOnly = true)
    @Override
    public Page<Customer> findAll(Pageable pageable) {

        return customerRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customer.setEnabled(true);
        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        List<Authority> validAuthorities =
                NEW_CUSTOMER_AUTHORITIES.stream().map(s -> authorityService.findByType(s)).toList();
        customer.setAuthoritySet(new HashSet<>(validAuthorities));
        customerRepository.save(customer);
//        customerRepository.save(customer);
    }

    @Override
    public void update(CustomerDto customerDto) {

        customerRepository.save(customerMapper.toEntity(customerDto));
    }

    @Transactional
    @Modifying
    @Override
    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Transactional
    @Override
    public Customer findById(Long customerId) {
       return customerRepository.findById(customerId).orElseThrow(()-> new RuntimeException("Customer not found"));
    }
}
