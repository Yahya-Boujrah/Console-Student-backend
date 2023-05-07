package com.consolestudent.controllers;

import com.consolestudent.model.Request;
import com.consolestudent.model.Response;
import com.consolestudent.service.RequestServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestServiceImp caseService;
    @PostMapping("/save")
    public ResponseEntity<Response> saveCase(@RequestBody Request caseTosave){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("case",caseService.create(caseTosave)))
                        .message("Case created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
