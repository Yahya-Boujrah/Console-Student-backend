package com.example.consolestudent.service;

import com.example.consolestudent.model.Case;
import com.example.consolestudent.repo.CaseRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CaseServiceImp  implements CaseService{
    private final CaseRepo caseRepo;
    @Override
    public Case create(Case caseToCreate) {
        log.info("saving new case: {}", caseToCreate.getId());
        return caseRepo.save(caseToCreate);
    }
}
