package com.example.appvaccine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_relationship")
public class RelationShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationShipID")
    private Integer relationShipId ;
    @Column(name = "relationShipName")
    private String relationShipName;

    @OneToOne(mappedBy = "relationShip",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Profile profile;


    public RelationShip() {
    }

    public RelationShip(String relationShipName) {
        this.relationShipName = relationShipName;
    }


}
