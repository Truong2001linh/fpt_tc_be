package com.example.appvaccine.controller;

import com.example.appvaccine.dto.AuthenticationResponse;
import com.example.appvaccine.request.OtpRegisterRequest;
import com.example.appvaccine.request.OtpResponseDto;
import com.example.appvaccine.request.OtpValidationRequest;
import com.example.appvaccine.request.RegisterRequest;
import com.example.appvaccine.service.AuthenticationService;
import com.example.appvaccine.service.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/register")
@Slf4j
@RequiredArgsConstructor
public class RegisterOtpController {

    private SmsService smsService;
    private final AuthenticationService service;

    @Autowired
    public RegisterOtpController(SmsService smsService, AuthenticationService service) {
        this.smsService = smsService;
        this.service = service;
    }


    @GetMapping("/process")
    public String processSMS() {
        return "SMS sent";
    }

    @PostMapping("/send-otp")
    public OtpResponseDto sendOtp(@RequestBody OtpRegisterRequest otpRequest) {
        log.info("inside sendOtp :: "+otpRequest.getPhoneNumber());
        return smsService.sendSMS(otpRequest);

    }
    @PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
        log.info("inside validateOtp :: "+otpValidationRequest.getPhoneNumber()+" "+otpValidationRequest.getOtpNumber());
        return smsService.validateOtp(otpValidationRequest);
    }
    @PostMapping("/setRegister")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request ){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPhoneNumber(request.getPhoneNumber());
        registerRequest.setPasswordUser(request.getPasswordUser());
        return ResponseEntity.ok(service.register(registerRequest));
    }


}
