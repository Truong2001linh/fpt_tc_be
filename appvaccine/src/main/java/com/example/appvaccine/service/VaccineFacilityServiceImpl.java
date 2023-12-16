package com.example.appvaccine.service;

import com.example.appvaccine.dao.VaccineFacilityRepository;
import com.example.appvaccine.dto.VaccineFacilityDTO;
import com.example.appvaccine.entity.VaccineFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class VaccineFacilityServiceImpl implements VaccineFacilityService {

    private final VaccineFacilityRepository vaccineFacilityRepository;

    @Autowired
    public VaccineFacilityServiceImpl(VaccineFacilityRepository vaccineFacilityRepository) {
        this.vaccineFacilityRepository = vaccineFacilityRepository;
    }

    @Override
    public List<VaccineFacilityDTO> getAllVaccinefacility() {
        List<VaccineFacility> vaccines = vaccineFacilityRepository.findAll();
        List<VaccineFacilityDTO> vaccineDTOs = new ArrayList<>();

        for (VaccineFacility vaccine : vaccines) {
            VaccineFacilityDTO dto = convertToDto(vaccine);
            vaccineDTOs.add(dto);
        }
        return vaccineDTOs;
    }

    public VaccineFacilityDTO convertToDto(VaccineFacility vaccineFacility){
        VaccineFacilityDTO vaccineFacilityDTO = new VaccineFacilityDTO();
        vaccineFacilityDTO.setFacilityName(vaccineFacility.getFacilityName());
        vaccineFacilityDTO.setPhoneNumber(vaccineFacility.getPhoneNumber());
        vaccineFacilityDTO.setAddressFacility(vaccineFacility.getAddressFacility());
        vaccineFacilityDTO.setStatusFacility(vaccineFacility.getStatusFacility());
        return vaccineFacilityDTO;
    }

    public VaccineFacility convertToEntity(VaccineFacilityDTO vaccineFacilityDTO){
        VaccineFacility vaccineFacility = new VaccineFacility();

        vaccineFacility.setFacilityName(vaccineFacilityDTO.getFacilityName());
        vaccineFacility.setPhoneNumber(vaccineFacilityDTO.getPhoneNumber());
        vaccineFacility.setAddressFacility(vaccineFacilityDTO.getAddressFacility());
        vaccineFacility.setStatusFacility(vaccineFacilityDTO.getStatusFacility());
        return vaccineFacility;
    }


}
