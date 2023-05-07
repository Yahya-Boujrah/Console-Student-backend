package com.consolestudent.repo;

import com.consolestudent.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Long> {
}
