package com.backend.diary.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private String userId;
    private String content;
    private String timestamp;
}
