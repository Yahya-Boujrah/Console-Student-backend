package com.consolestudent.service;

import com.consolestudent.model.Demande;
import com.consolestudent.model.User;
import com.consolestudent.payloads.ServiceRequest;
import com.consolestudent.payloads.UpdateRequest;
import com.consolestudent.repo.DemandeRepo;
import com.consolestudent.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Date;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class DemandeServiceImp implements DemandeService{
    private final DemandeRepo demandeRepo;
    private final UserRepository userRepository;

    private final SalesforceService salesforceService;


    @Override
    public Demande create(Demande demande) {
        log.info("saving new demande: {}", demande.getNom());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username + " service");
        User user = userRepository.findByEmail(username).orElseThrow();

        System.out.println(user);
        demande.setUser(user);
        demande.setEtat("Nouvelle");
        demande.setDateDemande(new Date());
        System.out.println(createInSalesforce(demande));
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
        deleteInSalesforce(id);
         demandeRepo.deleteById(id);
        return TRUE;
    }


    public Mono<ServiceRequest> createInSalesforce(Demande demande){

        ServiceRequest serviceRequest = ServiceRequest.builder()
                //.BackendId__c(String.valueOf(demande.getId()))
                .Name(demande.getNom())
                .Etat__c(demande.getEtat())
                .Type__c(demande.getType())
                .build();

        String oauthToken = salesforceService.loginSalesforce();
        System.out.println(oauthToken);

        return WebClient.builder().baseUrl("https://ensa-a7-dev-ed.develop.my.salesforce.com/services/apexrest/ServiceRequests").build()
                .post()
                //.uri("https://ensa-a7-dev-ed.develop.my.salesforce.com/services/apexrest/ServiceRequests/")
                .header("Authorization", "Bearer " + oauthToken)
                .body(Mono.just(serviceRequest), ServiceRequest.class)
                .retrieve()
                .bodyToMono(ServiceRequest.class);

    }


    public Mono<Void> deleteInSalesforce(Long id) {
        String oauthToken = salesforceService.loginSalesforce();

        return WebClient.builder().baseUrl("https://ensa-a7-dev-ed.develop.my.salesforce.com/services/apexrest/ServiceRequests/").build()
                .delete()
                .uri(String.valueOf(id))
                .header("Authorization", "Bearer " + oauthToken)
                .retrieve()
                .bodyToMono(Void.class);
    }


    public String updateStatus(String Id, UpdateRequest updateRequest){

        Demande demande = demandeRepo.findById(Long.valueOf(Id)).orElseThrow();
        demande.setEtat(updateRequest.getStatus());
        demandeRepo.save(demande);
        return "status updated to " + demande.getEtat();
    }
}
