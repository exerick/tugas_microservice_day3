package com.example.demo.day11.eureka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputData {

    @PostMapping("/customer")
    public String isiData(@RequestBody Customer customer)
    {
        return "Data Submited ID " + customer.getId() + " nama " +customer.getNama() + " alamat " +customer.getAlamat();
    }


}
