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
public class PersonalContactDto extends ContactDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    public PersonalContactDto(){
        this.setType(ContactType.PERSONAL);
    }
}
