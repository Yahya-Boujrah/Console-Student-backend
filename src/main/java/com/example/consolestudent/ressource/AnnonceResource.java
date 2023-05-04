package com.example.consolestudent.ressource;

import com.example.consolestudent.model.Response;
import com.example.consolestudent.service.AnnonceServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/annonces")
@RequiredArgsConstructor
public class AnnonceResource {
    private final AnnonceServiceImp annonceService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAnnonces(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("annonces",annonceService.list(20)))
                        .message("Announcements retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
