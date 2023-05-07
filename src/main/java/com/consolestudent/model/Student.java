package com.consolestudent.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "student")
public class Student {
    @Id
    private Long numApogee;
    private String cne;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String dateNaissance;
    private String lieuNaissance;
    private String tel;
    private String addresse;
    private String niveau;
    private String filiere;

}
