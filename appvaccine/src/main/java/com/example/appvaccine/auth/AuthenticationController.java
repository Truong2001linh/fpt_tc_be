package com.example.appvaccine.auth;

import com.example.appvaccine.entity.Role;
import com.example.appvaccine.entity.User;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request ){

        return ResponseEntity.ok(service.register(request));


    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest user ){
//        System.out.println("===== vaog ffaay");
//        if(name != null){
//            System.out.println("Data: " + name);
//        }else {
//            System.out.println("Ko nhan du lieu");
//        }
        return  ResponseEntity.ok(service.authenticate(user));
         //return ResponseEntity.ok(new AuthenticationResponse("token: qsfjri8sdf0sd2345.drdrftvtvtvgyv234556fgghj.gftujFDssdrAWS66675+++++++++++++"));

    }

}
