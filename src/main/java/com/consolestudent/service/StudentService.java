package com.consolestudent.service;

import com.consolestudent.model.Student;


public interface StudentService {
    Student getStudent(Long numApogee);
    Student updateStudent(Student student, Long numApogee);
}
