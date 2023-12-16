package com.example.appvaccine.service;

import com.example.appvaccine.dto.AuthenticationResponse;
import com.example.appvaccine.dao.RolesRepository;
import com.example.appvaccine.dao.UserRepository;
import com.example.appvaccine.entity.Role;
import com.example.appvaccine.entity.User;
import com.example.appvaccine.request.AuthenticationRequest;
import com.example.appvaccine.request.RegisterRequest;
import com.example.appvaccine.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private  PasswordEncoder passwordEncoder;
    private  UserRepository repository;

    private  AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private RolesRepository roleRepository;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository repository, AuthenticationManager authenticationManager, JwtService jwtService, RolesRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.roleRepository = roleRepository;

    }

    public AuthenticationResponse register(RegisterRequest request) {

        Role userRole = roleRepository.findByRoleId(1);
        User user = User.builder()
                .phoneNumber(request.getPhoneNumber())
                .passwordUser(passwordEncoder.encode(request.getPasswordUser()))
                .role(userRole) // Gán vai trò USER
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("okoko");
        System.out.println(request.getPhoneNumber() + request.getPasswordUser());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhoneNumber(),
                        request.getPasswordUser()
                )
        );

        System.out.println("Token");
        var user = repository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow();
        System.out.println(user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println("Token" + jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();


    }
}
