package com.example.appvaccine.dao;

import com.example.appvaccine.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile save(Profile profile);
}
