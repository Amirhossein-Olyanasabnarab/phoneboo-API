package dk.amir.dev.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.PersonalContact;
import dk.amir.dev.model.enums.ContactType;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalContact.class, name = "PERSONAL"),
        @JsonSubTypes.Type(value = BusinessContact.class, name = "BUSINESS"),
})

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class ContactDto {

    @Schema(name = "id", hidden = true, example = "1")
    private Long id;

    @Schema(name = "fullName", example = "John Doe")
    @NotBlank(message = "FullName is required.")
    private String fullName;

    @Schema(name = "phoneNumber", example = "09123456789")
    @NotBlank(message = "PhoneNumber is required.")
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d{9,12}$", message = "Invalid mobile phone number")
    private String phoneNumber;


    @Schema(name = "type", example = "PERSONAL")
    private ContactType type;

    @Schema(name = "deleted", hidden = true, example = "false")
    private Boolean deleted = false;

}
