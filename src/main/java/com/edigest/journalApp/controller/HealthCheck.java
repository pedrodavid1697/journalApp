package com.edigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check") //Get keyword using health-check end point
    public String healthCheck() {
        return "code run successfully";// will show on postman using URL+endpoints(health-check)
    }
}
