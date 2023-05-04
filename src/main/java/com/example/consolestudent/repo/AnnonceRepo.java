package com.example.consolestudent.repo;

import com.example.consolestudent.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnnonceRepo extends JpaRepository<Annonce,Long> {
}
