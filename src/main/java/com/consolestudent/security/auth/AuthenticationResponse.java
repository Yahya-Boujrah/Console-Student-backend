package com.consolestudent.security.auth;


import com.consolestudent.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor



public class AuthenticationResponse {


    private User user;

    private String token;

}
