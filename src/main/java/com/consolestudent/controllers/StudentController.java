package com.consolestudent.controllers;

import com.consolestudent.service.StudentServiceImp;
import com.consolestudent.model.Response;
import com.consolestudent.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/informations")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentServiceImp studentService;

    @GetMapping("/{numApogee}")
    public ResponseEntity<Response> getStudent(@PathVariable("numApogee") Long numApogee){
        return ResponseEntity.ok(
                Response.builder()
                        .data(Map.of("infomations", studentService.getStudent(numApogee)))
                        .message("fetching student byy numero apogee " + numApogee)
                        .build()
        );
    }

    @PutMapping("/{numApogee}")
    public ResponseEntity<Response> updateStudent(@RequestBody Student student, @PathVariable Long numApogee){
        return ResponseEntity.ok(
                Response.builder()
                        .data(Map.of("informations", studentService.updateStudent(student, numApogee)))
                        .message("Student updted")
                        .build()
        );
    }

}
