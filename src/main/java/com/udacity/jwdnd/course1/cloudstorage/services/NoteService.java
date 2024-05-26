package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.domain.Note;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {
    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @Override
    public void addNote(Note note) {
        this.noteMapper.insertNote(note);
    }

    @Override
    public List<Note> getAllNotesByUserId(Integer userId) {
        return noteMapper.findNotesByUserId(userId);
    }

    @Override
    public Note getNoteById(Integer id) {
        return noteMapper.findNoteById(id);
    }

    @Override
    public void updateNote(Note note) {
        this.noteMapper.updateNote(note);
    }

    @Override
    public void deleteNote(Integer id) {
        this.noteMapper.deleteNote(id);
    }
}
