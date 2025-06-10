package dk.amir.dev.service.impl;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.Contact;
import dk.amir.dev.model.entity.PersonalContact;
import dk.amir.dev.dao.repository.ContactRepository;
import dk.amir.dev.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact addContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact contact = repository.findById(id).get();
        contact.setFullName(updatedContact.getFullName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        return repository.save(contact);
    }

    @Override
    public boolean deleteContact(Long id) {
        Contact contact = repository.findById(id).get();
        contact.setDeleted(true);
        repository.save(contact);
        return true;
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return repository.findById(id).get();
    }
}
