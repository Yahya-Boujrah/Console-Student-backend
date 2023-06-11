package com.consolestudent.service;


import com.consolestudent.model.Note;
import com.consolestudent.model.Result;
import com.consolestudent.model.User;
import com.consolestudent.payloads.ResultRequest;
import com.consolestudent.repo.NoteRepo;
import com.consolestudent.repo.ResultRepo;
import com.consolestudent.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepo resultRepo;

    private final UserRepository userRepo;

    private final NoteRepo noteRepo;

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
                .notes(notes)
                .build();

       return resultRepo.save(result1);

    }

    public Result getResult(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email).orElseThrow();
        return resultRepo.findByCne(user.getCne()).orElseThrow();
    }

    public List<Note> notes(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email).orElseThrow();
        Result result = resultRepo.findByCne(user.getCne()).orElseThrow();
        return noteRepo.findByResult(result).orElseThrow();
    }
}
