package com.example.appvaccine.auth;

import com.example.appvaccine.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String phoneNumber;
    private String passwordUser;
    private Role role;
}
