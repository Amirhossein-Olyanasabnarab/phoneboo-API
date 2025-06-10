package dk.amir.dev.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.amir.dev.model.entity.BusinessContact;
import dk.amir.dev.model.entity.PersonalContact;
import dk.amir.dev.model.enums.ContactType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;
    private String email;


    @Column(name = "type", insertable = false, updatable = false)
    private ContactType type;
    private Boolean deleted = false;

}
