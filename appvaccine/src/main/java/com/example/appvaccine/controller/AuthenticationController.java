package com.example.appvaccine.controller;

import com.example.appvaccine.dto.AuthenticationResponse;
import com.example.appvaccine.service.AuthenticationService;
import com.example.appvaccine.request.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest user ){
        return  ResponseEntity.ok(service.authenticate(user));
    }


}
