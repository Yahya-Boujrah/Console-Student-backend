package com.consolestudent.repo;


import com.consolestudent.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepo extends JpaRepository<Demande,Long> {
}
