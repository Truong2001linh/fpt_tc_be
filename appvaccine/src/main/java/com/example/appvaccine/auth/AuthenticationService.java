package com.example.appvaccine.auth;

import com.example.appvaccine.dao.RolesRepository;
import com.example.appvaccine.dao.UserRepository;
import com.example.appvaccine.entity.Role;
import com.example.appvaccine.entity.User;
import com.example.appvaccine.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RolesRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("jasdhfkashd");

        Role userRole = roleRepository.findRoleByRoleName(String.valueOf(request.getRole()))
                .orElseThrow(() -> new RuntimeException("Error: Role USER is not found."));
        System.out.println(userRole);
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