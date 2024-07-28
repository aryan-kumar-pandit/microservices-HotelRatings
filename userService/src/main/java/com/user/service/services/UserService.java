package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);
    //get all user
    List<User> getAllUser();
    // get single user
    User getUser(String userId);

}
