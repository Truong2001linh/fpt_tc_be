package com.example.appvaccine.service;

import com.example.appvaccine.dao.UserRepository;
import com.example.appvaccine.entity.User;
import com.example.appvaccine.request.ChangePasswordRequest;
import com.example.appvaccine.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User changePassword(ChangePasswordRequest changePasswordRequest) throws Exception {
        // Giả sử token được lấy từ changePasswordRequest hoặc từ một phương thức khác
        String token = changePasswordRequest.getPhoneNumber();

        if (token == null || token.isEmpty()) {
            throw new Exception("Token không hợp lệ hoặc bị trống");
        }

        String userNameByToken = jwtService.extractUserName(token);
        User user = userRepository.findUserByPhoneNumber(userNameByToken);
        System.out.println(user.toString());


        if (user == null) {
            throw new Exception("Không tìm thấy người dùng");
        }

        if (!passwordEncoder.matches(changePasswordRequest.getPasswordOld(),user.getPasswordUser() )) {
            throw new Exception ("Mật khẩu cũ không đúng.");
        }
        if (!changePasswordRequest.getPasswordNew().equals(changePasswordRequest.getPasswordNewValidate())) {
            throw new Exception("Mật khẩu mới và mật khẩu xác nhận không khớp");
        }

        // Thêm mã hóa mật khẩu tại đây nếu cần
        String encryptedNewPassword = passwordEncoder.encode(changePasswordRequest.getPasswordNew());
        user.setPasswordUser(encryptedNewPassword);

        return userRepository.save(user);
    }
}
