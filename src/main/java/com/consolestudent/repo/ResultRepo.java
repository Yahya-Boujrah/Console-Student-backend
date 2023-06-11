package com.consolestudent.repo;

import com.consolestudent.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long> {
    Optional<Result> findByCne(String cne);
}
