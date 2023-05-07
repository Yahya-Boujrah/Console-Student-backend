package com.consolestudent.repo;

import com.consolestudent.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnnonceRepo extends JpaRepository<Annonce,Long> {
}
