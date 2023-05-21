package com.consolestudent.security.auth;



import com.consolestudent.email.EmailSender;
import com.consolestudent.email.EmailUtil;
import com.consolestudent.model.Role;
import com.consolestudent.model.User;
import com.consolestudent.repo.UserRepository;
import com.consolestudent.security.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmailSender sender;

    @Autowired
    EmailUtil emailUtil;

    public AuthenticationResponse register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        String jwtToken = jwtService.generateToken(user);
        
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        System.out.println(request);
        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .user(user)
                .token(jwtToken)
                .build();
    }

    public String getOldPassword(PasswordRequest request){

        User user = repository.findByCne(request.getCne()).orElseThrow();

        this.sender.send(user.getEmail(),emailUtil.buildEmail(user.getNom() +" "+ user.getPrenom(),user.getCne(), user.getNom()+user.getCin()));

        return "Check your email";

    }

    public String changeOldPassword(PasswordChangeRequest request){
        User user = repository.findByEmail(request.getEmail()).orElseThrow();


        if (passwordEncoder.matches(request.getPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode("newpassword"));
            repository.save(user);
            System.out.println("changed");
        }
        return "password changed";
    }

}
