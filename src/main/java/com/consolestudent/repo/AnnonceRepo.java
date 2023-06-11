package com.consolestudent.repo;

import com.consolestudent.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce,Long> {
    public Optional<Annonce> findBySalesforceId(String  salesforceId);
}
