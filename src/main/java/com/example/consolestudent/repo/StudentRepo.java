package com.example.consolestudent.repo;

import com.example.consolestudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
