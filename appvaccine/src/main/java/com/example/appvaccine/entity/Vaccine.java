package com.example.appvaccine.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccineID")
    private Integer vaccineId;
    @Column(name = "vaccineName")
    private String vaccineName;
    @Column(name = "origin")
    private String origin;
    @Column(name = "price")
    private Long price;
    @Column(name = "usageVaccine")
    private String usageVaccine;
    @Column(name = "information")
    private String information;
    @Column(name = "attentionVaccine")
    private String attentionVaccine;
    @Column(name = "statusVaccine")
    private String statusVaccine;
    @Column(name = "imageVaccine")
    private String imageVaccine;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "tbl_vaccination_registration_detail",
            joinColumns = @JoinColumn(name = "vaccineID"),
            inverseJoinColumns = @JoinColumn(name = "registrantion")
    )
    private List<VaccinationRegist> vaccinationRegists;

}
