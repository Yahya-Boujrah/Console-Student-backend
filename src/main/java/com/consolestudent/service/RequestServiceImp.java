package com.consolestudent.service;

import com.consolestudent.model.Request;
import com.consolestudent.repo.RequestRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RequestServiceImp implements RequestService {
    private final RequestRepo requestRepo;

    @Override
    public Request create(Request caseToCreate) {
        log.info("saving new case: {}", caseToCreate.getId());
        return requestRepo.save(caseToCreate);
    }
}
