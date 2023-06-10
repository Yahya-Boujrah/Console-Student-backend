package com.consolestudent.service;


import com.consolestudent.payloads.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
@Service
public class SalesforceService {



    @Value("${salesforce.token_url}")
    String tokenUrl;

    @Value("${salesforce.username}")
    String username;

    @Value("${salesforce.password}")
    String password;

    @Value("${salesforce.client_id}")
    String clientId ;

    @Value("${salesforce.client_secret}")
    String clientSecret;

    @Value("${salesforce.redirect_uri}")
    String redirectUri;

    public String loginSalesforce(){

        return WebClient.builder().baseUrl(tokenUrl).build()
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(BodyInserters.fromFormData("grant_type", "password")
                        .with("username", username)
                        .with("password", password)
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("redirect_uri", redirectUri))
                .retrieve()
                .bodyToMono(AccessTokenResponse.class)
                .block()
                .getAccessToken();

    }
}
