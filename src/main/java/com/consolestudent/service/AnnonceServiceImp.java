package com.consolestudent.service;

import com.consolestudent.model.Annonce;
import com.consolestudent.repo.AnnonceRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AnnonceServiceImp implements AnnonceService{
    private final AnnonceRepo annonceRepo;
    @Override
    public Collection<Annonce> list(int limit) {
        log.info("fetching all Announcements");
        return annonceRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    public Annonce saveAnnonce(Annonce annonce){
       return annonceRepo.save(annonce);
    }
}
