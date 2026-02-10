package com.edigest.journalApp.controller;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check") //Get keyword using health-check end point
    public String healthCheck() {
        return "code run successfully";// will show on postman using URL+endpoints(health-check)
    }

//    @GetMapping //EndPoint
//    public List<User> getAllUsers(){
//        return userService.getAll();
//    }

    @PostMapping("/create-user") //Endpoint
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user); //Void class never returns

    }
}
