package com.edigest.journalApp.controller;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserRepository;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

//import java.time.LocalDateTime;


@RestController
@RequestMapping("/user") //endpoint
public class UserController {
    // It will contain many types of controller inside it
    // REST Controller is a special type of classes, special type of components
    // which will handle our HTTP

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping //EndPoint
//    public List<User> getAllUsers(){
//        return userService.getAll();
//    }

//    @PostMapping //Endpoint
//    public void createUser(@RequestBody User user) {
//
//        userService.saveEntry(user); //Void class never returns
//
//    }

    @PutMapping()  //Endpoint
    public ResponseEntity<?> updateUser (@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserById () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}