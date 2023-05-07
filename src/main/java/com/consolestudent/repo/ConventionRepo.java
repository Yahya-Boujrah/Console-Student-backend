package com.consolestudent.repo;

import com.consolestudent.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionRepo extends JpaRepository<Convention,Long> {
}
