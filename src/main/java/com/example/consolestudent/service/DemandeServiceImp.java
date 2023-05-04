package com.example.consolestudent.service;

import com.example.consolestudent.model.Demande;
import com.example.consolestudent.repo.DemandeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class DemandeServiceImp implements DemandeService{
    private final DemandeRepo demandeRepo;
    @Override
    public Demande create(Demande demande) {
        log.info("saving new demande: {}", demande.getNom());
        demande.setEtat("Nouvelle");
        demande.setDateDemande(new Date());
        return demandeRepo.save(demande);
    }

    @Override
    public Collection<Demande> list() {
        log.info("fetching all Demands");
        return demandeRepo.findAll();
    }

    @Override
    public Demande get(Long id) {
        log.info("fetching Demand by id: {}",id);
        return demandeRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting Demand by id: {}",id);
         demandeRepo.deleteById(id);
        return TRUE;
    }
}
