package com.example.appvaccine.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String addressProfile;
    private String email;
    private int userId;
}
