package dk.amir.dev.service.impl;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public PersonalContactDto createPersonalContact(PersonalContactDto dto) {
        return null;
    }

    @Override
    public BusinessContactDto createBusinessContact(BusinessContactDto dto) {
        return null;
    }

    @Override
    public PersonalContactDto getPersonalContactById(Long id) {
        return null;
    }

    @Override
    public BusinessContactDto getBusinessContactById(Long id) {
        return null;
    }

    @Override
    public List<PersonalContactDto> getPersonalContacts() {
        return List.of();
    }

    @Override
    public List<BusinessContactDto> getBusinessContacts() {
        return List.of();
    }

    @Override
    public PersonalContactDto updatePersonalContact(Long id, PersonalContactDto dto) {
        return null;
    }

    @Override
    public BusinessContactDto updateBusinessContact(Long id, BusinessContactDto dto) {
        return null;
    }

    @Override
    public boolean deletePersonalContact(Long id) {
        return false;
    }
}
