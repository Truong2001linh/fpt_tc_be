package com.example.appvaccine.controller;

import com.example.appvaccine.request.OtpRegisterRequest;
import com.example.appvaccine.request.OtpResponseDto;
import com.example.appvaccine.request.OtpValidationRequest;
import com.example.appvaccine.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
@Slf4j
public class OtpController {

    @Autowired
    private SmsService smsService;

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

}
