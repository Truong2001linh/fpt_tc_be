package com.example.appvaccine.service;

import com.example.appvaccine.dao.UserRepository;
import com.example.appvaccine.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findByUserId(id);
    }
}
