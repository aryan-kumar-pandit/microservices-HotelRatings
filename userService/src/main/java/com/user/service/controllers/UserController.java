package com.user.service.controllers;

import com.user.service.entities.User;
import com.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    // creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex)
    {
        logger.info("Fallback is executed because service is down :{}",ex.getMessage());
        User user = User.builder().email("dummy@emmail").name("dummy").about("this user is dummy").userId("1234").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUser = userService.getAllUser();
        return  ResponseEntity.ok(allUser);
    }
}
