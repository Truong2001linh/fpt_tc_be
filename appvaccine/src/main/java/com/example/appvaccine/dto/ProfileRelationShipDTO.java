package com.example.appvaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRelationShipDTO {
    private int relationShipID;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String addressProfile;
    private String email;
    private int userId;
}
