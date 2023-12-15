package com.example.appvaccine.request;

import com.example.appvaccine.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpRegisterRequest {
    private String phoneNumber;
}
