package com.backend.diary.service;

import com.backend.diary.model.Note;
import com.backend.diary.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getNotesByUserId(String userId) {
        return noteRepository.findByUserId(userId);
    }
}
