package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
import com.bridgelabz.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    IGreetingService iGreetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fName", defaultValue = "world") String firstName ,
                             @RequestParam(value="lName")String lastName) {
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return iGreetingService.addGreeting(user);
    }
}
