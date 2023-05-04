package com.example.consolestudent.repo;

import com.example.consolestudent.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionRepo extends JpaRepository<Convention,Long> {
}
