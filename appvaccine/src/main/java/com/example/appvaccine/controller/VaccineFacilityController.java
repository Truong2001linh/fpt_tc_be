package com.example.appvaccine.controller;

import com.example.appvaccine.dto.VaccineFacilityDTO;
import com.example.appvaccine.service.VaccineFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaccineFacility")
@RequiredArgsConstructor
public class VaccineFacilityController {
    @Autowired
    private VaccineFacilityService vaccineFacilityService;

    @GetMapping("/getAll")
    public List<VaccineFacilityDTO> getAllVacine(){
        return vaccineFacilityService.getAllVaccinefacility();
    }
}
