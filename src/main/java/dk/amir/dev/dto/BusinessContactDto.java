package dk.amir.dev.dto;

import dk.amir.dev.model.enums.ContactType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class BusinessContactDto extends ContactDto {

    @NotBlank(message = "Company name is required")
    private String companyName;

    public BusinessContactDto(){
        this.setType(ContactType.BUSINESS);
    }
}
