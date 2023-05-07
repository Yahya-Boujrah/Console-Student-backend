package com.consolestudent.service;

import com.consolestudent.model.Student;
import com.consolestudent.repo.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public Student getStudent(Long numApogee) {
        log.info("fetching student by numero apogee {} ", numApogee);
        return studentRepo.findById(numApogee).get();
    }

    @Override
    public Student updateStudent(Student student, Long numApogee) {
        log.info("update student by numero apogee {}", student.getNumApogee());
        return studentRepo.save(student);
    }
}
