package com.system.contactbackend.systemcontactbackend.service;

import java.util.List;

import com.system.contactbackend.systemcontactbackend.DTO.DTOContactRequest;
import com.system.contactbackend.systemcontactbackend.model.Contact;

public interface ContactService {

    public Contact save(DTOContactRequest dto) throws Exception;

    public List<Contact> getAll() throws Exception;

    public Contact get(String id) throws Exception;

    public Contact update(String id, DTOContactRequest dto) throws Exception;

    public void delete(String id) throws Exception;

}
