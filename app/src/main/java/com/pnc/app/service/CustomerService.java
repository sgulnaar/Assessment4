package com.pnc.app.service;

import com.pnc.app.domain.Customer;
import com.pnc.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
   CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(){
        return  customerRepository.findAll();
    }

    public Optional<Customer> get(int creditCardNo) {
        return customerRepository.findById(creditCardNo);
    }

    public Customer save(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
