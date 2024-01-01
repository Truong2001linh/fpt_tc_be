package com.example.appvaccine.controller;

import com.example.appvaccine.dto.VaccineFacilityDTO;
import com.example.appvaccine.service.VaccineFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vaccineFacility")
@RequiredArgsConstructor
public class VaccineFacilityController {
    private VaccineFacilityService vaccineFacilityService;

    @Autowired
    public VaccineFacilityController(VaccineFacilityService vaccineFacilityService) {
        this.vaccineFacilityService = vaccineFacilityService;
    }

    @GetMapping("/getAll")
    public List<VaccineFacilityDTO> getAllVacine(){
        return vaccineFacilityService.getAllVaccinefacility();
    }
}
