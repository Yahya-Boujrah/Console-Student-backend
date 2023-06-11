package com.consolestudent.repo;

import com.consolestudent.model.Note;
import com.consolestudent.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {
    public Optional<List<Note>> findByResult(Result result);
}
