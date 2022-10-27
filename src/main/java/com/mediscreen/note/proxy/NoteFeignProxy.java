package com.mediscreen.note.proxy;

import com.mediscreen.note.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mediscreen-note", url = "${note.serviceUrl:http://localhost:8082}")
public interface NoteFeignProxy {

    @GetMapping("/api/notes/patient/{patientId}")
    ResponseEntity<List<Note>> findByPatientId(@PathVariable(value = "patientId") Long patientId);

    @GetMapping("/api/notes/patient")
    List<Note> findNoteByLastNameAndFirstName(@RequestParam("lastName") String patientLastName, @RequestParam("firstName") String patientFirstName);

}
