package com.system.contactbackend.systemcontactbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.system.contactbackend.systemcontactbackend.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {
    
}
