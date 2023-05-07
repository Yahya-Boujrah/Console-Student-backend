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
public class Convention {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String type;
    private String nomSociete;
    private String adresseSociete;
    private String EmailSociete;
    private String NomRepresentantSociete;
    private String NomRepresentantEcole;
    private String sujetStage;
    private Date dateDebutStage;
    private Date dateFinStage;
    private String nomEncadrantSociete;
    private String nomEncadrantEcole;
    private String numeroContrantAssurance;
    private int montantGratification;
    private String modalitePaiementGratification;

}
