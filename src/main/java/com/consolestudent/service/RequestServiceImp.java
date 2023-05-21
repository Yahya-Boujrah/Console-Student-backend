package com.consolestudent.service;

import com.consolestudent.model.Request;
import com.consolestudent.model.User;
import com.consolestudent.repo.RequestRepo;
import com.consolestudent.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RequestServiceImp implements RequestService {
    private final RequestRepo requestRepo;
    private final UserRepository userRepository;

    @Override
    public Request create(Request caseToCreate) {
        log.info("saving new case: {}", caseToCreate.getId());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        caseToCreate.setUser(user);
        return requestRepo.save(caseToCreate);
    }
}
