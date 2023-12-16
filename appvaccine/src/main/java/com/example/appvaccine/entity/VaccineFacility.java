package com.example.appvaccine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_vaccination_facility")
public class VaccineFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccinationFacilityID")
    private Integer vaccineFacilityId;

    @Column(name = "facilityName")
    private String facilityName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "addressFacility")
    private String addressFacility;

    @Column(name = "statusFacility")
    private String statusFacility;

    @OneToMany(mappedBy = "vaccineFacility",
            fetch = FetchType.LAZY,
            cascade =  {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<VaccinationRegist> vaccinationRegists;

}
