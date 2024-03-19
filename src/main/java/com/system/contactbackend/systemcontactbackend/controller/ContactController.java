package com.system.contactbackend.systemcontactbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.contactbackend.systemcontactbackend.DTO.DTOContactRequest;
import com.system.contactbackend.systemcontactbackend.service.ContactService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contacts")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<?> save(@Validated @RequestBody DTOContactRequest contact) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contact));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(contactService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(contactService.get(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @Validated @RequestBody DTOContactRequest contactRequest) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(contactService.update(id, contactRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        try{
            contactService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
