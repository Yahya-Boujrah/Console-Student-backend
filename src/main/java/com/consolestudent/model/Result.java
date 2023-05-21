package com.consolestudent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

        private String name;
        private Float note_finale;

        @OneToMany(mappedBy = "result", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Note> notes;

}

