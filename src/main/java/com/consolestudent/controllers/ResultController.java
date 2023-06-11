package com.consolestudent.controllers;

import com.consolestudent.model.Response;
import com.consolestudent.model.Result;
import com.consolestudent.payloads.ResultRequest;
import com.consolestudent.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveResults(@RequestBody ResultRequest result){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("results",resultService.saveResult(result)))
                        .message("results saved")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }


    @GetMapping("/listNotes")
    public ResponseEntity<Response> listNotes(){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("notes",resultService.notes()))
                        .message("notes retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("getResult")
    public ResponseEntity<Response> getResult(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("result",resultService.getResult()))
                        .message("result retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
