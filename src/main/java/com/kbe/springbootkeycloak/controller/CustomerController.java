package com.kbe.springbootkeycloak.controller;

import com.kbe.springbootkeycloak.model.Customer;
import com.kbe.springbootkeycloak.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/admin/customer")
    @RolesAllowed("admin")
    public ResponseEntity<Customer> saveEmployee(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @GetMapping("/user/customer")
    @RolesAllowed({"customer","admin"})
    public ResponseEntity<List<Customer>> getCustomer(){
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
