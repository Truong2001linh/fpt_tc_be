package com.example.appvaccine.entity;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Integer userId;

    @Column(name = "passwordUser")
    private String passwordUser;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID")
    private Role role;

    @OneToMany(mappedBy = "users",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<Profile> profiles;


    public User(String passwordUser, String phoneNumber) {
        this.passwordUser = passwordUser;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getPassword() {
        return passwordUser;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
