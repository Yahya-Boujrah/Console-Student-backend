package com.example.consolestudent.ressource;

import com.example.consolestudent.model.Case;
import com.example.consolestudent.model.Response;
import com.example.consolestudent.service.CaseServiceImp;
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
@RequestMapping("/cases")
@RequiredArgsConstructor
public class CaseResource {

    private final CaseServiceImp caseService;
    @PostMapping("/save")
    public ResponseEntity<Response> saveCase(@RequestBody Case caseTosave){
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
