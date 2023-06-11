package com.consolestudent.payloads;

import lombok.Data;

import java.util.List;

@Data
public class ResultRequest {

    private Float note_finale;
    private List<String> notes;
    private String name;
    private String cne;
}
