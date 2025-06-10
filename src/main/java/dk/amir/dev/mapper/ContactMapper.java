package dk.amir.dev.mapper;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.ContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.Contact;
import dk.amir.dev.model.entity.PersonalContact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    PersonalContact toEntity(PersonalContactDto dto);
    PersonalContactDto toDto(PersonalContact entity);

    BusinessContact toEntity(BusinessContactDto dto);
    BusinessContactDto toDto(BusinessContact entity);

    default Contact toEntity(Object dto){
        if(dto instanceof BusinessContactDto){
            return toEntity((BusinessContactDto)dto);
        }else if(dto instanceof PersonalContactDto){
            return toEntity((PersonalContactDto)dto);
        }
        throw new  IllegalArgumentException("Unsupported dto" + dto.getClass());
    }

    default ContactDto toDto(Contact entity){
        if(entity instanceof BusinessContact){
            return toDto((BusinessContact)entity);
        }else if(entity instanceof PersonalContact){
            return toDto((PersonalContact)entity);
        }
        throw new  IllegalArgumentException("Unsupported entity" + entity.getClass());
    }
}
