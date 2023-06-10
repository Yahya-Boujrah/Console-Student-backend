package com.consolestudent.security.auth;


import com.consolestudent.model.Response;
import com.consolestudent.model.User;
import com.consolestudent.service.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.spec.ECParameterSpec;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    SalesforceService salesforceService;

    @Autowired
    AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
//        System.out.println(salesforceService.loginSalesforce());
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/getpassword")
    public ResponseEntity<Response> getPassword(@RequestBody PasswordRequest request){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("message", service.getOldPassword(request)))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping("/isPasswordChanged")
    public ResponseEntity<Response> isPasswordChanged(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("isPasswordChanged", service.isPasswordChanged()))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
