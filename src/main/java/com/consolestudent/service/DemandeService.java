package com.consolestudent.service;


import com.consolestudent.model.Demande;

import java.util.Collection;

public interface DemandeService {
    Demande create (Demande demande);
    Collection<Demande> list();
    Demande get(Long id);
    Boolean delete(Long id);

}
