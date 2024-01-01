package com.example.appvaccine.service;

import com.example.appvaccine.entity.User;
import com.example.appvaccine.request.ChangePasswordRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findUserById(int id);


    List<User> getAll();

    User changePassword(ChangePasswordRequest changePasswordRequest) throws Exception;

}
