package com.example.consolestudent.service;



import com.example.consolestudent.model.Convention;

import java.util.Collection;

public interface ConventionService {

    Convention create (Convention convention);
    Collection<Convention> list();
    Convention get(Long id);
    Convention update(Convention convention);
    Boolean delete(Long id);
}
