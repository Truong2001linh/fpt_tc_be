package com.example.appvaccine.service;

import com.example.appvaccine.dto.VaccineDTO;
import com.example.appvaccine.entity.Vaccine;

import java.util.List;

public interface VaccineService {


    VaccineDTO createVaccine(VaccineDTO vaccineDTO);

    List<VaccineDTO> getAllVacine ();

    Vaccine findById(int id);


    List<VaccineDTO> getAllVaccinesWithImages();
}
