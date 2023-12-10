package com.example.appvaccine.service;

import com.example.appvaccine.dao.VaccineRepository;
import com.example.appvaccine.dto.VaccineDTO;
import com.example.appvaccine.entity.Vaccine;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VaccineImpl implements VaccineService {
    private final VaccineRepository vaccineRepository;

    public VaccineImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public VaccineDTO createVaccine(VaccineDTO vaccineDTO) {
        // Chuyển đổi từ VaccineDTO sang Vaccine entity
        Vaccine vaccine = convertToEntity(vaccineDTO);
        // Lưu Vaccine entity vào cơ sở dữ liệu
        Vaccine savedVaccine = vaccineRepository.save(vaccine);
        // Chuyển đổi Vaccine entity đã lưu trở lại thành VaccineDTO để trả về
        return convertToDto(savedVaccine);
    }

    @Override
    public List<VaccineDTO> getAllVacine() {

        List<Vaccine> vaccines = vaccineRepository.findAll();
        List<VaccineDTO> vaccineDTOs = new ArrayList<>();

        for (Vaccine vaccine : vaccines) {
            VaccineDTO dto = convertToDto(vaccine);
            vaccineDTOs.add(dto);
        }
        return vaccineDTOs;
    }

    @Override
    public Vaccine findById(int id) {
        return vaccineRepository.findById(id);
    }

    @Override
    public List<VaccineDTO> getAllVaccinesWithImages() {
        // Lấy danh sách từ cơ sở dữ liệu
        List<Vaccine> vaccines = vaccineRepository.findAll();
        // Chuyển đổi danh sách entity sang DTO
        return vaccines.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    private VaccineDTO convertToDto(Vaccine savedVaccine) {
        // Tạo một instance mới của VaccineDTO và set các giá trị từ Vaccine entity
        VaccineDTO vaccineDTO = new VaccineDTO();
        vaccineDTO.setVaccineName(savedVaccine.getVaccineName());
        vaccineDTO.setOrigin(savedVaccine.getOrigin());
        vaccineDTO.setPrice(savedVaccine.getPrice());
        vaccineDTO.setUsageVaccine(savedVaccine.getUsageVaccine());
        vaccineDTO.setInformation(savedVaccine.getInformation());
        vaccineDTO.setAttentionVaccine(savedVaccine.getAttentionVaccine());
        vaccineDTO.setStatusVaccine(savedVaccine.getStatusVaccine());
        vaccineDTO.setImageVaccine(savedVaccine.getImageVaccine());
        // Thêm các set giá trị khác nếu cần
        return vaccineDTO;
    }

    private Vaccine convertToEntity(VaccineDTO vaccineDTO) {
        // Tạo một instance mới của Vaccine entity và set các giá trị từ VaccineDTO
        Vaccine vaccine = new Vaccine();
        vaccine.setVaccineName(vaccineDTO.getVaccineName());
        vaccine.setOrigin(vaccineDTO.getOrigin());
        vaccine.setPrice(vaccineDTO.getPrice());
        vaccine.setUsageVaccine(vaccineDTO.getUsageVaccine());
        vaccine.setInformation(vaccineDTO.getInformation());
        vaccine.setAttentionVaccine(vaccineDTO.getAttentionVaccine());
        vaccine.setStatusVaccine(vaccineDTO.getStatusVaccine());
        vaccine.setImageVaccine(vaccineDTO.getImageVaccine());
        // Thêm các set giá trị khác nếu cần
        return vaccine;
    }
}
