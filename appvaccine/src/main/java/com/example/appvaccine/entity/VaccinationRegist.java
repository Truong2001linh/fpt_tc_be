package com.example.appvaccine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_vaccination_registration")
public class VaccinationRegist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrantionID")
    private Integer registrantionId;

    @Column(name = "registrationDate")
    private Date registrationDate;

    @Column(name = "totalPrice")
    private long totalPrice;

    @Column(name = "statusPayVc")
    private String statusPayVc;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "vaccinationFacilityID")
    private VaccineFacility vaccineFacility;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "paymentID")
    private  Pay pay;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "profileID")
    private Profile profile;

    @OneToMany(mappedBy = "vaccinationRegist",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Log> logs;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
                name = "tbl_vaccination_registration_detail",
                joinColumns = @JoinColumn(name = "registrantionID"),
                inverseJoinColumns = @JoinColumn(name = "vaccineID")
        )
    private List<Vaccine> vaccines;

}

