package com.example.demo.day11.userid;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestUserIdController {

    List<User> listUser= new ArrayList<>();

    @GetMapping("/user/{userId}")
    public Optional<User> getUserId(@PathVariable String userId) {
        return listUser.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();
    }


    @PostMapping("/user")
    public User getUser(@RequestBody User user)
    {
        listUser.add(user);
        return user;

    }






}
