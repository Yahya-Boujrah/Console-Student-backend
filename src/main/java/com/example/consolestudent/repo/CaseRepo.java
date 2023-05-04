package com.example.consolestudent.repo;

import com.example.consolestudent.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepo extends JpaRepository<Case,Long> {
}
