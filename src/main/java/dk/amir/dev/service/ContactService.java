package dk.amir.dev.service;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;

import java.util.List;

public interface ContactService {

    PersonalContactDto createPersonalContact(PersonalContactDto dto);
    BusinessContactDto createBusinessContact(BusinessContactDto dto);

    PersonalContactDto getPersonalContactById(Long id);
    BusinessContactDto getBusinessContactById(Long id);

    List<PersonalContactDto> getPersonalContacts();
    List<BusinessContactDto> getBusinessContacts();

    PersonalContactDto updatePersonalContact(Long id, PersonalContactDto dto);
    BusinessContactDto updateBusinessContact(Long id, BusinessContactDto dto);

    boolean deletePersonalContact(Long id);


}
