package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.domain.Note;

import java.util.List;

public interface INoteService {
    void addNote(Note note);
    List<Note> getAllNotesByUserId(Integer userId);
    Note getNoteById(Integer id);
    void updateNote(Note note);
    void deleteNote(Integer id);

}
