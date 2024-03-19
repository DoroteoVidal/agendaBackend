package com.system.contactbackend.systemcontactbackend.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.system.contactbackend.systemcontactbackend.DTO.DTOContactRequest;
import com.system.contactbackend.systemcontactbackend.exception.ResourceNotFoundException;
import com.system.contactbackend.systemcontactbackend.model.Contact;
import com.system.contactbackend.systemcontactbackend.repository.ContactRepository;
import com.system.contactbackend.systemcontactbackend.service.ContactService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper; //Mapea un objeto a una clase especifica. Automatizar

    @Override
    public Contact save(DTOContactRequest dto) throws Exception {
        try{
            Contact contact = mapper.map(dto, Contact.class);
            contact.setCreatedAt(LocalDateTime.now());

            return contactRepository.save(contact);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Contact> getAll() throws Exception {
        try{
            return contactRepository.findAll();
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Contact get(String id) throws Exception {
        try{
            return contactRepository.findById(id).get();
        }catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Contact update(String id, DTOContactRequest dto) throws Exception {
        try{      
            Contact contact = contactRepository.findById(id).get();
            mapper.map(dto, contact);
            contactRepository.save(contact);
            
            return contact;         
        }catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void delete(String id) throws Exception {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            contactRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException();
        }
    }
    
}
