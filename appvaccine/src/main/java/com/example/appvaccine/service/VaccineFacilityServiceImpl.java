package com.example.appvaccine.service;

import com.example.appvaccine.dto.VaccineDTO;
import com.example.appvaccine.dto.VaccineFacilityDTO;
import com.example.appvaccine.entity.VaccineFacility;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class VaccineFacilityServiceImpl implements VaccineFacilityService {
    @Override
    public List<VaccineFacilityDTO> getAllVaccinefacility() {
        return null;
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
