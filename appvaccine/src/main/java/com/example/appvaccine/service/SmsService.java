package com.example.appvaccine.service;

import com.example.appvaccine.request.OtpRegisterRequest;
import com.example.appvaccine.request.OtpResponseDto;
import com.example.appvaccine.request.OtpStatus;
import com.example.appvaccine.request.OtpValidationRequest;
import com.example.appvaccine.security.TwilioConfig;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
@Slf4j
public class SmsService {
    private final TwilioConfig twilioConfig;
    Map<String, String> otpMap = new HashMap<>();
    @Autowired
    public SmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }


    public OtpResponseDto sendSMS(OtpRegisterRequest otpRequest) {
        OtpResponseDto otpResponseDto = null;
        try {
            PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());//to
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
            String otp = generateOTP();
            String otpMessage = "Dear Customer , Your OTP is  " + otp + " for sending sms through Spring boot application. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(otpRequest.getPhoneNumber(), otp);
            otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            otpResponseDto = new OtpResponseDto(OtpStatus.FAILED, e.getMessage());
        }
        return otpResponseDto;
    }

    public String validateOtp(OtpValidationRequest otpValidationRequest) {
        Set<String> keys = otpMap.keySet();
        String username = null;
        for(String key : keys)
            username = key;
        if (otpValidationRequest.getPhoneNumber().equals(username)) {
            otpMap.remove(username,otpValidationRequest.getOtpNumber());
            return "OTP is valid!";
        } else {
            return "OTP is invalid!";
        }
    }

    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
