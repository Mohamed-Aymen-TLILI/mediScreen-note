package com.mediscreen.note.controller;

import com.mediscreen.note.exceptions.NoteNotFoundException;
import com.mediscreen.note.model.Note;
import com.mediscreen.note.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Api(tags = "API de l'enregistrement des notes patients")
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/patHistory/add")
    @ApiOperation(value = "Créer une nouvelle note")
    public Note addNote(@RequestParam Integer patientId, @RequestParam String note) {
        Note noteToCreate = new Note(patientId, note, LocalDate.now());
        return noteService.addNote(noteToCreate);
    }

    @GetMapping("/patHistory")
    @ApiOperation(value = "Chercher les notes par patientId")
    public List<Note> getNotesForPatient(@RequestParam Integer patientId) {
        return noteService.getNotesForPatient(patientId);
    }

    @GetMapping("/patHistory/get")
    @ApiOperation(value = "Chercher les notes par id")
    public Note getNote(@RequestParam String noteId) throws NoteNotFoundException {
        return noteService.getNoteById(noteId);
    }

    @PutMapping("/patHistory/update")
    @ApiOperation(value = "Mettre à jour les notes du patient par id")
    public Note updateNote(@RequestParam String noteId, @RequestParam Integer patientId, @RequestParam String note) throws NoteNotFoundException {
        Note noteToUpdate = new Note(noteId,patientId,note);
        return noteService.updateNote(noteToUpdate);
    }

    @DeleteMapping("/notes/note/{id}")
    @ApiOperation(value = "Supprimer les notes du patient par son id")
    public void deleteNoteById(@PathVariable("id") final String noteId) {
        noteService.deleteNoteById(noteId);

    }

}

