package com.consolestudent.service;

import com.consolestudent.model.Convention;
import com.consolestudent.model.User;
import com.consolestudent.repo.ConventionRepo;
import com.consolestudent.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ConventionServiceImp implements ConventionService{
    private final ConventionRepo conventionRepo;
    private final UserRepository userRepository;
    @Override
    public Convention create(Convention convention) {
        log.info("saving new convention: {}", convention.getType());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        convention.setUser(user);
        return conventionRepo.save(convention);
    }

    @Override
    public Collection<Convention> list() {
        log.info("fetching all Conventions");
        return conventionRepo.findAll();
    }

    @Override
    public Convention get(Long id) {
        log.info("fetching Convention by id: {}",id);
        return conventionRepo.findById(id).get();
    }

    @Override
    public Convention update(Convention convention) {
        log.info("updating convention: {}", convention.getType());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        convention.setUser(user);
        return conventionRepo.save(convention);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting Convention by id: {}",id);
        conventionRepo.deleteById(id);
        return TRUE;
    }
}
