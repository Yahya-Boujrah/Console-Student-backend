package com.example.consolestudent.repo;


import com.example.consolestudent.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepo extends JpaRepository<Demande,Long> {
}
