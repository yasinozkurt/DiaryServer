package com.backend.diary.controller;

import com.backend.diary.model.Note;
import com.backend.diary.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        note.setUserId(username);
        noteService.save(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> getNotes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Note> notes = noteService.getNotesByUserId(username);
        return ResponseEntity.ok(notes);
    }
}