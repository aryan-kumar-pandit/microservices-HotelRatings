package com.user.service.services.imlp;

import com.user.service.Repository.UserRepository;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String uid = UUID.randomUUID().toString();
        user.setUserId(uid);
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id not found"));
    }
}
