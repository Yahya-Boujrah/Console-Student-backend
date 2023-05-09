package com.consolestudent.repo;

import com.consolestudent.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConventionRepo extends JpaRepository<Convention,Long> {
}
