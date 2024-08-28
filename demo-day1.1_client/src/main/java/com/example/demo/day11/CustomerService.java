package com.example.demo.day11;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {


    private final String apiUrl = "http://localhost:8761/customer";

    public String submitCustomer(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, customer, String.class);
        return response.getBody();
    }
}
