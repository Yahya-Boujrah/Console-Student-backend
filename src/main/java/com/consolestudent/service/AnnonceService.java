package com.consolestudent.service;

import com.consolestudent.model.Annonce;

import java.util.Collection;

public interface AnnonceService {
    Collection<Annonce> list(int limit);


}
