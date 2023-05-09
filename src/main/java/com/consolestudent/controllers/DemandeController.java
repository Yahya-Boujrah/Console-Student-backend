package com.consolestudent.controllers;


import com.consolestudent.model.Demande;
import com.consolestudent.model.Response;
import com.consolestudent.service.DemandeServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/demandes")
@RequiredArgsConstructor
public class DemandeController {
    private final DemandeServiceImp demandeService;

    @GetMapping("/list")
    public ResponseEntity<Response> getDemands(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("demandes",demandeService.list()))
                        .message("Demands retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveDemand(@RequestBody Demande demande){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("demande",demandeService.create(demande)))
                        .message("Demand created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDemand(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("demandes",demandeService.get(id)))
                        .message("Demand retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
        @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Response> deleteDemand(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("demandes",demandeService.delete(id)))
                        .message("Demand deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
