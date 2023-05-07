package com.consolestudent.security.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.spec.ECParameterSpec;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


    @GetMapping("/getpassword")
    public ResponseEntity<String> getPassword(@RequestBody PasswordRequest request){
        return ResponseEntity.ok(service.getOldPassword(request));
    }


    @PutMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest request){
        return ResponseEntity.ok(service.changeOldPassword(request));
    }



}
