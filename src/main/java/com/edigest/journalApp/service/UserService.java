package com.edigest.journalApp.service;


//Business logic written here

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j // Logs will print no longer need to provide package/class names

public class UserService {

    @Autowired
    private UserRepository userRepository; //Using Dependency Injection here,  as we are injecting journalEntryRepository to this class
    // this is an interface and interface should have implementations so, spring will inject implementation in runtime to this class


//    private static final Logger logger = LoggerFactory.getLogger(UserService.class); // will need to write this everywhere when we need logs there, instead of that we can use @Slf4j
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    public void saveNewUser(User user) { //Creating Put Call Endpoint
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList("User"));
//        userRepository.save(user);
//
//    }

    public boolean saveNewUser(User user) { //Creating Put Call Endpoint
            try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("User"));
            userRepository.save(user);
            return true;
        }
        catch (Exception e) {
//          log.info("Error occured for {} :", user.getUserName(),e); //{} -> Place holder; logback error configured to modify console logs.
            log.info("info log comes here");
            log.error("Hahahahha");
            log.warn("when we get warning using this");
            log.debug("debug issue");
            log.trace("When we added trace config manually");
            return false;
        }
    }

    public void saveAdmin(User user) { //Creating Put Call Endpoint
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User", "ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(User user) { //Creating Put Call Endpoint

        userRepository.save(user);
    }

    public List<User> getAll() { //Creating Get Call Endpoint
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }

}
