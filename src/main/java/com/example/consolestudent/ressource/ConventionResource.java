package com.example.consolestudent.ressource;

import com.example.consolestudent.model.Convention;
import com.example.consolestudent.model.Response;
import com.example.consolestudent.service.ConventionServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/conventions")
@RequiredArgsConstructor
public class ConventionResource {
    private final ConventionServiceImp conventionService;

    @GetMapping("/list")
    public ResponseEntity<Response> getConventions(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("conventions",conventionService.list()))
                        .message("conventions retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveConvention(@RequestBody Convention convention){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("convention",conventionService.create(convention)))
                        .message("Convention created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @PutMapping("/update")
    public ResponseEntity<Response> updateConvention(@RequestBody Convention convention){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("convention",conventionService.update(convention)))
                        .message("Convention updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getConvention(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                            .data(Map.of("conventions",conventionService.get(id)))
                        .message("Convention retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Response> deleteConvention(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("conventions",conventionService.delete(id)))
                        .message("Convention deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
