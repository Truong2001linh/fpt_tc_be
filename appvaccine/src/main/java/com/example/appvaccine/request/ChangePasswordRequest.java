package com.example.appvaccine.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    private String phoneNumber;
    private String passwordOld;
    private String passwordNew;
    private String passwordNewValidate;
}
