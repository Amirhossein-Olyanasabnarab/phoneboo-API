package dk.amir.dev.service.impl;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.Contact;
import dk.amir.dev.model.entity.PersonalContact;
import dk.amir.dev.repository.ContactRepository;
import dk.amir.dev.service.ContactService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public ContactServiceImpl(ContactRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    @Override
    public PersonalContactDto createPersonalContact(PersonalContactDto dto) {

        PersonalContact contact = mapper.map(dto, PersonalContact.class);
        return mapper.map(repository.save(contact), PersonalContactDto.class);
    }

    @Override
    public BusinessContactDto createBusinessContact(BusinessContactDto dto) {

        BusinessContact contact = mapper.map(dto, BusinessContact.class);
        return mapper.map(repository.save(contact), BusinessContactDto.class);
    }

    @Override
    public PersonalContactDto getPersonalContactById(Long id) {

        Contact contact = repository.findById(id).orElse(null);
        return contact != null ?mapper.map(contact, PersonalContactDto.class) : null;

    }

    @Override
    public BusinessContactDto getBusinessContactById(Long id) {

        Contact contact = repository.findById(id).orElse(null);
        return contact != null ? mapper.map(contact, BusinessContactDto.class) : null;

    }

    @Override
    public List<PersonalContactDto> getPersonalContacts() {

        return repository.findAll()
                .stream()
                .filter(c -> c instanceof  PersonalContact)
                .map(c -> mapper.map(c, PersonalContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BusinessContactDto> getBusinessContacts() {

        return repository.findAll()
                .stream()
                .filter(c -> c instanceof BusinessContact)
                .map(c -> mapper.map(c, BusinessContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonalContactDto updatePersonalContact(Long id, PersonalContactDto dto) {
        Contact contact = repository.findById(id).orElseThrow( () -> new RuntimeException("Contact not found"));

        if (contact instanceof  PersonalContact){
            PersonalContact personal = (PersonalContact) contact;

            personal.setFullName(dto.getFullName());
            personal.setPhoneNumber(dto.getPhoneNumber());
            personal.setEmail(dto.getEmail());
            personal.setNationality(dto.getNationality());

            PersonalContact update = repository.save(personal);
            return mapper.map(update, PersonalContactDto.class);
        }
        else {
            throw new RuntimeException("Not a personal contact");
        }
    }

    @Override
    public BusinessContactDto updateBusinessContact(Long id, BusinessContactDto dto) {

        Contact contact = repository.findById(id)
                .orElseThrow( () -> new RuntimeException("Contact not found"));

        if(contact instanceof  BusinessContact businessContact){

            businessContact.setFullName(dto.getFullName());
            businessContact.setPhoneNumber(dto.getPhoneNumber());
            businessContact.setEmail(dto.getEmail());
            businessContact.setCompanyName(dto.getCompanyName());

            BusinessContact update = repository.save(businessContact);
            return mapper.map(update, BusinessContactDto.class);
        }else {
            throw new RuntimeException("Not a business contact");
        }
    }

    @Override
    public boolean deletePersonalContact(Long id) {
        return false;
    }
}
