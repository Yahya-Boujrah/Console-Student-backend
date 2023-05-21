package com.consolestudent.service;

import com.consolestudent.model.User;
import com.consolestudent.repo.UserRepository;
import com.consolestudent.security.auth.PasswordChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public String changeOldPassword(PasswordChangeRequest request){

        String usernmae = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = repository.findByEmail(usernmae).orElseThrow();

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setIsPasswordChanged(Boolean.TRUE);
        repository.save(user);
        return "password changed";
    }
}
