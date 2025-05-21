package dk.amir.dev.model.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("PERSONAL")
public class PersonalContact extends Contact{

    private String nationality;

    public PersonalContact(String fullName, String phoneNumber, String email, String nationality) {
        super(fullName, phoneNumber, email);
        this.nationality = nationality;
    }
}
