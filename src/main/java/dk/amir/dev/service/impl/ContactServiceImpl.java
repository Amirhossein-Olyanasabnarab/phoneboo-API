package dk.amir.dev.service.impl;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.PersonalContact;
import dk.amir.dev.repository.ContactRepository;
import dk.amir.dev.service.ContactService;
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
        return null;
    }

    @Override
    public BusinessContactDto getBusinessContactById(Long id) {
        return null;
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
