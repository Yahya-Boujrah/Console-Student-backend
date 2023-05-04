package com.example.consolestudent.model;

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
public class Case {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String sujet;
    private String description;
    private Date date;
    private String studentId;
    private String priorite;
    private String origine;
    private String Statut;
    private String motifRejet;
    private String commentaire;
}
