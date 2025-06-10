package dk.amir.dev.facade;

import dk.amir.dev.dto.ContactDto;


import java.util.List;

public interface ContactFacade {
    ContactDto addContact(ContactDto contact);
    ContactDto updateContact(Long id, ContactDto updatedContact);
    boolean deleteContact(Long id);
    List<ContactDto> getAllContacts();
    ContactDto getContactById(Long id);
}
