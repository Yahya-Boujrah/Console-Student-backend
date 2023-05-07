package com.consolestudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    private String niveaux;
    private String filiere;
    private Date datePublication;

}
