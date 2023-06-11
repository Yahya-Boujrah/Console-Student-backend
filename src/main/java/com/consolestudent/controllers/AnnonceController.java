package com.consolestudent.controllers;

import com.consolestudent.model.Annonce;
import com.consolestudent.model.Response;
import com.consolestudent.payloads.AnnonceFileRequest;
import com.consolestudent.service.AnnonceServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/annonces")
@RequiredArgsConstructor
public class AnnonceController {
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
    @PostMapping("/save")
        public ResponseEntity<Annonce> saveAnnonce(@RequestBody Annonce annonce){
        return ResponseEntity.ok(annonceService.saveAnnonce(annonce));
    }

    @PostMapping("/saveFiles")
    public ResponseEntity<Annonce> saveFiles(@RequestBody AnnonceFileRequest request){
        return ResponseEntity.ok(annonceService.saveAnnonceFile(request));
    }


}
