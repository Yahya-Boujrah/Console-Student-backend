package com.consolestudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String module;
    private Float note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result result;
}
