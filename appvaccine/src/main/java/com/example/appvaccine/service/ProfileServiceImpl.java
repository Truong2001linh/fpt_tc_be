package com.example.appvaccine.service;

import com.example.appvaccine.dao.ProfileRepository;
import com.example.appvaccine.dto.ProfileDTO;
import com.example.appvaccine.entity.Profile;
import com.example.appvaccine.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final UserService userService;
    private final ProfileRepository profileService;

    public ProfileServiceImpl(UserService userService, ProfileRepository profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @Override
    public ProfileDTO addProfileByUser(ProfileDTO profileDTO) {
        int userId = profileDTO.getUserId();
        User user = userService.findUserById(userId);
        if (user != null) {
            // Người dùng tồn tại, thêm hồ sơ
             Profile profile = profileService.save(convertToEntity(profileDTO));

             return convertToDto(profile);

        } else {
            // Người dùng không tồn tại, xử lý lỗi hoặc trả về thông báo lỗi
            // Ví dụ: throw Exception hoặc trả về thông báo lỗi
            throw new RuntimeException(new Exception("Không tìm thấy người dùng"));
        }

    }
    private ProfileDTO convertToDto(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setFullName(profile.getFullName());
        profileDTO.setDateOfBirth(profile.getDateOfBirth());
        profileDTO.setGender(profile.getGender());
        profileDTO.setAddressProfile(profile.getAddressProfile());
        profileDTO.setEmail(profile.getEmail());
        profileDTO.setUserId(profile.getUsers().getUserId());

        return profileDTO;

    }

    private Profile convertToEntity(ProfileDTO profileDTO){
        Profile profile = new Profile();

        profile.setFullName(profileDTO.getFullName());
        profile.setDateOfBirth(profileDTO.getDateOfBirth());
        profile.setGender(profileDTO.getGender());
        profile.setAddressProfile(profileDTO.getAddressProfile());
        profile.setEmail(profileDTO.getEmail());
        profile.setUsers(userService.findUserById(profileDTO.getUserId()));

        return profile;

    }
}
