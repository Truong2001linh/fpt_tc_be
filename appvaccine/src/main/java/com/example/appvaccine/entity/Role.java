package com.example.appvaccine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@Table(name = "tbl_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleID")
    private Integer roleId;

    @Column(name = "roleName")
    private String roleName;

    @OneToMany(mappedBy = "role",
               fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<User> users;

    public Role() {
    }

    @Override
    public String toString() {
        return roleName;

    }
}
