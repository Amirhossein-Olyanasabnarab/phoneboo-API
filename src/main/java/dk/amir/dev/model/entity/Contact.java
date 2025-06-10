package dk.amir.dev.model.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.amir.dev.model.enums.ContactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalContact.class, name = "PERSONAL"),
        @JsonSubTypes.Type(value = BusinessContact.class, name = "BUSINESS"),
})

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Contact {

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
