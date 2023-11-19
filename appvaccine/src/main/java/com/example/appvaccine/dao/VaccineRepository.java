package com.example.appvaccine.dao;

import com.example.appvaccine.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VaccineRepository extends JpaRepository<Vaccine,Integer> {

//     Vaccine createVaccine(Vaccine vaccine);
}
