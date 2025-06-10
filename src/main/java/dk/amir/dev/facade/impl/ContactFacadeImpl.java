package dk.amir.dev.facade.impl;

import dk.amir.dev.dto.ContactDto;
import dk.amir.dev.facade.ContactFacade;
import dk.amir.dev.mapper.ContactMapper;
import dk.amir.dev.model.entity.Contact;
import dk.amir.dev.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactFacadeImpl implements ContactFacade {

    private final ContactMapper mapper;
    private final ContactService service;
    @Autowired
    public ContactFacadeImpl(ContactMapper mapper, ContactService service) {
        this.mapper = mapper;
        this.service = service;
    }


    @Override
    public ContactDto addContact(ContactDto contact) {
        Contact newContact = mapper.toEntity(contact);
        return mapper.toDto(service.addContact(newContact));
    }

    @Override
    public ContactDto updateContact(Long id, ContactDto updatedContact) {
        Contact newContact = mapper.toEntity(updatedContact);
        return mapper.toDto(service.updateContact(id, newContact));
    }

    @Override
    public boolean deleteContact(Long id) {
        return service.deleteContact(id);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        return service.getAllContacts()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto getContactById(Long id) {
        return mapper.toDto(service.getContactById(id));
    }
}
