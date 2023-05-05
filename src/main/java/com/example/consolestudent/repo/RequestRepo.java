package com.example.consolestudent.repo;

import com.example.consolestudent.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Long> {
}
