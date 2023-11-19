package com.example.appvaccine.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileID")
    private Integer profileId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "addressProfile")
    private String addressProfile;

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User users;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "relationShipID")
    private  RelationShip relationShip;

    @OneToMany(mappedBy = "profile",
            fetch = FetchType.LAZY,
            cascade =  {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<VaccinationRegist> vaccinationRegists;

    public Profile(String fullName, Date dateOfBirth, String gender, String addressProfile, String email) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.addressProfile = addressProfile;
        this.email = email;
    }
}
