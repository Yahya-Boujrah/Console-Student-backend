package com.consolestudent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String type;
    private String sujet;
    private String description;
    private Date date;
    private String priorite;
    private String origine;
    private String Statut;
    private String motifRejet;
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
