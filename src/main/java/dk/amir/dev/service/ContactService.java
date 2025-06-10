package dk.amir.dev.service;

import dk.amir.dev.model.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact addContact(Contact contact);
    Contact updateContact(Long id, Contact updatedContact);
    boolean deleteContact(Long id);
    List<Contact> getAllContacts();
    Contact getContactById(Long id);

}
