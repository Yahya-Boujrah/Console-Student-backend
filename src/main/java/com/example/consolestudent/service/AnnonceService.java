package com.example.consolestudent.service;

import com.example.consolestudent.model.Annonce;

import java.util.Collection;

public interface AnnonceService {
    Collection<Annonce> list(int limit);
}
