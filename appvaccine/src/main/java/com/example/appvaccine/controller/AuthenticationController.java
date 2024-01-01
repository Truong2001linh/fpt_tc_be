package com.example.appvaccine.controller;

import com.example.appvaccine.dao.UserRepository;
import com.example.appvaccine.dto.AuthenticationResponse;
import com.example.appvaccine.entity.User;
import com.example.appvaccine.request.ChangePasswordRequest;
import com.example.appvaccine.service.AuthenticationService;
import com.example.appvaccine.request.AuthenticationRequest;
import com.example.appvaccine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserService userService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest user ){
        return  ResponseEntity.ok(service.authenticate(user));
    }

    @PutMapping("/changePassword")
    public User changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) throws Exception {
        return userService.changePassword(changePasswordRequest);
    }


}
