package com.consolestudent.controllers;

import com.consolestudent.model.Response;
import com.consolestudent.security.auth.PasswordChangeRequest;
import com.consolestudent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/changepassword")
    public ResponseEntity<Response> changePassword(@RequestBody PasswordChangeRequest request){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("message",userService.changeOldPassword(request)))
                        .message("password changed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
                );
    }

}
