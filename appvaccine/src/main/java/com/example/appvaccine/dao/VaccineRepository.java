package com.example.appvaccine.dao;

import com.example.appvaccine.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Integer> {


     Vaccine save(Vaccine vaccine);

     List<Vaccine> findAll();

     Vaccine findById(int id);
}
