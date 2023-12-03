package com.example.appvaccine.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {
    private String vaccineName;
    private String origin;
    private Long price;
    private String usageVaccine;
    private String information;
    private String attentionVaccine;
    private String statusVaccine;
    private String imageVaccine;

}
