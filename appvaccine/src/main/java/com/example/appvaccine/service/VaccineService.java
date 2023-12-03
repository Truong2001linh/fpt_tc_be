package com.example.appvaccine.service;

import com.example.appvaccine.dto.VaccineDTO;
import com.example.appvaccine.entity.Vaccine;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VaccineService {


    VaccineDTO createVaccine(VaccineDTO vaccineDTO);

    List<VaccineDTO> getAllVacine ();

    Vaccine findById(int id);

    VaccineDTO saveVaccine(VaccineDTO vaccineDTO, MultipartFile file);

    List<VaccineDTO> getAllVaccinesWithImages();
}
