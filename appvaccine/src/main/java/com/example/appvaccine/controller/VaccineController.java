package com.example.appvaccine.controller;

import com.example.appvaccine.dto.VaccineDTO;

import com.example.appvaccine.entity.Vaccine;
import com.example.appvaccine.service.ImgurService;
import com.example.appvaccine.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
public class VaccineController {
    @Autowired
    private final ImgurService imgurService;

    @Autowired
    private final VaccineService vaccineService;

    @PostMapping("/addVaccine")
    public ResponseEntity<VaccineDTO> addVaccine(
            @ModelAttribute VaccineDTO vaccineDTO,
            @RequestParam("image") MultipartFile image) throws IOException {
        String imageUrl = imgurService.uploadImage(image);
        // Đặt tên file vào DTO
        vaccineDTO.setImageVaccine(imageUrl);
        // Xử lý logic lưu VaccineDTO, ví dụ thông qua vaccine
        VaccineDTO vaccineDTO1 = vaccineService.createVaccine(vaccineDTO);
        return ResponseEntity.ok(vaccineDTO1);
    }

    // Endpoint để lấy danh sách vaccine kèm theo ảnh
    @GetMapping("/getAllVacine1")
    public ResponseEntity<List<VaccineDTO>> getAllVaccinesWithImages() {
        List<VaccineDTO> vaccineDTOs = vaccineService.getAllVaccinesWithImages();
        return ResponseEntity.ok(vaccineDTOs);
    }


    @GetMapping("/getAllVacine")
    public ResponseEntity<List<VaccineDTO>> getVaccineById() throws IOException {
        List<VaccineDTO> vaccineDTOs = vaccineService.getAllVacine();
        vaccineDTOs.forEach(dto -> {
            String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/vaccine-images/")
                    .path(dto.getImageVaccine())
                    .toUriString();
            dto.setImageVaccine(imageUrl); // Đảm bảo VaccineDTO có phương thức setImageUrl
        });

        return ResponseEntity.ok(vaccineDTOs);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Vaccine> getVaccineDTOById(@PathVariable int id) {

        Vaccine vaccineDTO = vaccineService.findById(id);
        return ResponseEntity.ok().body(vaccineDTO);
    }
}
