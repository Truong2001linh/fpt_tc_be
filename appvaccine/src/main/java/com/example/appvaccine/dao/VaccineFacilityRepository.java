package com.example.appvaccine.dao;

import com.example.appvaccine.entity.VaccineFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineFacilityRepository extends JpaRepository<VaccineFacility, Integer> {
    List<VaccineFacility> findAll();
}
