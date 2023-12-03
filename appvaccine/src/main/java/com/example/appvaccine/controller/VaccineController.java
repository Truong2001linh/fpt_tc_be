package com.example.appvaccine.controller;

import com.example.appvaccine.dto.VaccineDTO;

import com.example.appvaccine.entity.Vaccine;
import com.example.appvaccine.service.VaccineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {


    public static String uploadDirectory = System.getProperty("user.dir") + "src/main/resources/images";

    @Autowired
    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/addVaccine")
    public ResponseEntity<VaccineDTO> addVaccine(
            @ModelAttribute VaccineDTO vaccineDTO,
            @RequestParam("image") MultipartFile image) throws IOException {
// Làm sạch và xác minh tên file
        String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));

        // Tạo đường dẫn file an toàn trên server
        Path uploadPath = Paths.get(uploadDirectory);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Lưu file vào thư mục tải lên
        try (InputStream inputStream = image.getInputStream()) {
            Path filePath = uploadPath.resolve(originalFilename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException("Could not save image file: " + originalFilename, ex);
        }

        // Đặt tên file vào DTO
        vaccineDTO.setImageVaccine(originalFilename);

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

    @PostMapping("/upload")
    public ResponseEntity<VaccineDTO> uploadVaccineImage(@RequestParam("vaccineData") String vaccineData,
                                                         @RequestParam("file") MultipartFile file) {
        try {
            // Convert JSON string to DTO
            VaccineDTO vaccineDTO = new ObjectMapper().readValue(vaccineData, VaccineDTO.class);

            // Process the file and save to database through service
            VaccineDTO savedVaccineDTO = vaccineService.saveVaccine(vaccineDTO, file);

            // Return the saved DTO with status CREATED
            return new ResponseEntity<>(savedVaccineDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions (JSON conversion, file processing, etc.)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Vaccine> getVaccineDTOById(@PathVariable int id) {

        Vaccine vaccineDTO = vaccineService.findById(id);
        return ResponseEntity.ok().body(vaccineDTO);
    }
}
