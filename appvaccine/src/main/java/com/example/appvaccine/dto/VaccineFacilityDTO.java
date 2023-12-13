package com.example.appvaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineFacilityDTO {
    private String facilityName;
    private String phoneNumber;
    private String addressFacility;
    private String statusFacility;
}
