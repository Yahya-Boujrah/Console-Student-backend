package com.consolestudent.service;


import com.consolestudent.model.Note;
import com.consolestudent.model.Result;
import com.consolestudent.payloads.ResultRequest;
import com.consolestudent.repo.ResultRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepo resultRepo;

    public Result saveResult(ResultRequest result){

        List<Note> notes = new ArrayList<>();

        for (String test : result.getNotes()){
                notes.add(Note.builder()
                        .module(test.split(":")[0])
                        .note(Float.valueOf(test.split(":")[1]))
                        .build());
        }
        Result result1 = Result.builder()
                .name(result.getName())
                .cne(result.getCne())
                .note_finale(result.getNote_finale())
                .build();
        notes.forEach(note -> note.setResult(result1));

        result1.setNotes(notes);

       return resultRepo.save(result1);

    }
}
