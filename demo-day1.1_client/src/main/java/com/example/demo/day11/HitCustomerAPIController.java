package com.example.demo.day11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HitCustomerAPIController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/submit-customer")
    public String submitCustomer(@RequestBody Customer customer) {
        return customerService.submitCustomer(customer);
    }

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

}
