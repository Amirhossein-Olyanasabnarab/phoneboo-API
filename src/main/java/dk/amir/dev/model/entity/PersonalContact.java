package dk.amir.dev.model.entity;

import dk.amir.dev.model.enums.ContactType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class PersonalContact extends Contact{

    private String nationality;

    public PersonalContact(){
        this.setType(ContactType.PERSONAL);
    }
}
