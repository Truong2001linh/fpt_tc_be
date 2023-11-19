//package com.example.appvaccine.service;
//
//import com.example.appvaccine.dao.VaccineRepository;
//import com.example.appvaccine.dto.VaccineDTO;
//import com.example.appvaccine.entity.Vaccine;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class VaccineServiceImpl implements VaccineService {
//    private Path rootLocation;
//    private VaccineRepository vaccineRepository;
//    @Autowired
//    public VaccineServiceImpl(Path rootLocation, VaccineRepository vaccineRepository) {
//        this.rootLocation = rootLocation;
//        this.vaccineRepository = vaccineRepository;
//    }
//
//
//
//    @Override
//    public Vaccine createVaccine(VaccineDTO vaccineDTO, MultipartFile image) {
//        Path staticPath = Paths.get("static");
//        Path imagePath = Paths.get("images");
//        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//        }
//        Path file = CURRENT_FOLDER.resolve(staticPath)
//                .resolve(imagePath).resolve(image.getOriginalFilename());
//        try (OutputStream os = Files.newOutputStream(file)) {
//            os.write(image.getBytes());
//        }
//    }
//}
