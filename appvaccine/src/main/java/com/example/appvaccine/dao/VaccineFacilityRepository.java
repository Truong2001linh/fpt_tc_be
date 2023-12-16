package com.example.appvaccine.dao;

import com.example.appvaccine.entity.VaccineFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VaccineFacilityRepository extends JpaRepository<VaccineFacility, Integer> {
    @Query(value = "select * from tbl_vaccination_facility",nativeQuery = true)
    List<VaccineFacility> findAll();
}
