package com.mediscreen.note.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;





@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="Note")
public class Note {
    @Id
    private String id;

    @NotNull(message = "Patient Id is mandatory")
    private Integer patientId;

    @NotBlank(message =  "Note is mandatory and can not be empty")
    @Field(value = "note")
    private String note;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Field(value = "createdDate")
    private LocalDate createdDate;

    public Note(String noteId, Integer patientId, String note)
    {
        this.id = noteId;
        this.patientId = patientId;
        this.note = note;
    }

    public Note(Integer patientId, String note, LocalDate createdDate)
    {
        this.patientId = patientId;
        this.note =note;
        this.createdDate = createdDate;
    }
}
