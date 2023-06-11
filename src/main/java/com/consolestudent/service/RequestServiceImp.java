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
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RequestServiceImp implements RequestService {
    private final RequestRepo requestRepo;
    private final UserRepository userRepository;

    private final SalesforceService salesforceService;

    @Override
    public Request create(Request caseToCreate) {
        log.info("saving new case: {}", caseToCreate.getId());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        caseToCreate.setUser(user);
        return requestRepo.save(caseToCreate);
    }



    public Mono<CaseRequest> createInSalesforce(Request caseToCreate){

        CaseRequest caseRequest = CaseRequest.builder()
//                .Name("")
//                .Etat__c("")
//                .Type__c("")
                .build();

        String oauthToken = salesforceService.loginSalesforce();

        return WebClient.builder().baseUrl("https://ensa-a7-dev-ed.develop.my.salesforce.com/services/apexrest/ServiceRequests").build()
                .post()
                .header("Authorization", "Bearer " + oauthToken)
                .body(Mono.just(caseRequest), CaseRequest.class)
                .retrieve()
                .bodyToMono(CaseRequest.class);

    }
}
