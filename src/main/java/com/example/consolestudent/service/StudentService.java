package com.example.consolestudent.service;

import com.example.consolestudent.model.Student;

import java.util.Collection;


public interface StudentService {
    Student getStudent(Long numApogee);
    Student updateStudent(Student student, Long numApogee);
}
