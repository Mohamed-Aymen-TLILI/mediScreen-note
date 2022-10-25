package com.mediscreen.note.noteRepository;

import com.mediscreen.note.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,String> {

    List<Note> findByPatientIdOrderByCreatedDateAsc(Integer patientId);
}
