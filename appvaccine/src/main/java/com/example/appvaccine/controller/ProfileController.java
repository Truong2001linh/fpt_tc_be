package com.example.appvaccine.controller;

import com.example.appvaccine.dto.ProfileDTO;
import com.example.appvaccine.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private  ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/addProfile")
    public ProfileDTO addProfile(@RequestBody ProfileDTO profileDTO){
        return profileService.addProfileByUser(profileDTO);
    }
}
