package com.system.contactbackend.systemcontactbackend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "contact_collection")
public class Contact {
    
    @Id
    private String id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public Contact() {}

    public Contact(String name, String email, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }
    
}
