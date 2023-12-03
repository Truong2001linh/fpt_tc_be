package com.example.appvaccine.service;

import com.example.appvaccine.dao.VaccineRepository;
import com.example.appvaccine.dto.VaccineDTO;
import com.example.appvaccine.entity.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VaccineImpl implements VaccineService {
    @Autowired
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
    public VaccineDTO saveVaccine(VaccineDTO vaccineDTO, MultipartFile file) {
        try {
            // Convert MultipartFile to byte array
            byte[] imageBytes = file.getBytes();
            Vaccine vaccine = new Vaccine();

            // Set properties from DTO to Entity
            vaccine.setVaccineName(vaccineDTO.getVaccineName());
            vaccine.setOrigin(vaccineDTO.getOrigin());
            vaccine.setPrice(vaccineDTO.getPrice());
            vaccine.setUsageVaccine(vaccineDTO.getUsageVaccine());
            vaccine.setInformation(vaccineDTO.getInformation());
            vaccine.setAttentionVaccine(vaccineDTO.getAttentionVaccine());
            vaccine.setStatusVaccine(vaccineDTO.getStatusVaccine());
            // ... other properties
            vaccine.setImageVaccine(imageBytes); // Set image bytes

            // Save vaccine entity to the database
            Vaccine vaccine1 = vaccineRepository.save(vaccine);

            // Convert Entity back to DTO
            // vaccineDTO.setImageVaccine(Base64.getEncoder().encodeToString(vaccine1.getImageVaccine()));
            // ... set other properties

            return convertToDto(vaccine1);
        } catch (IOException e) {
            // Handle exceptions (file conversion, database errors, etc.)
            throw new RuntimeException("Error processing file", e);
        }
    }

    @Override
    public List<VaccineDTO> getAllVaccinesWithImages() {
        // Lấy danh sách từ cơ sở dữ liệu
        List<Vaccine> vaccines = vaccineRepository.findAll();

        // Chuyển đổi danh sách entity sang DTO và mã hóa ảnh
        List<VaccineDTO> vaccineDTO = vaccines.stream().map(vaccine -> {
            VaccineDTO dto = new VaccineDTO();
            // Set các trường khác từ vaccine sang dto

            dto.setVaccineName(vaccine.getVaccineName());
            dto.setOrigin(vaccine.getOrigin());
            dto.setPrice(vaccine.getPrice());
            dto.setUsageVaccine(vaccine.getUsageVaccine());
            dto.setInformation(vaccine.getInformation());
            dto.setAttentionVaccine(vaccine.getAttentionVaccine());
            dto.setStatusVaccine(vaccine.getStatusVaccine());


            // ...
            if (vaccine.getImageVaccine() != null) {
                String base64Image = Base64.getEncoder().encodeToString(vaccine.getImageVaccine());
                dto.setImageVaccine(base64Image);
            }
            return dto;
        }).collect(Collectors.toList());

        return vaccineDTO;
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
        vaccineDTO.setImageVaccine(Arrays.toString(savedVaccine.getImageVaccine()));
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
        vaccine.setImageVaccine(vaccineDTO.getImageVaccine().getBytes());
        // Thêm các set giá trị khác nếu cần
        return vaccine;
    }
}
