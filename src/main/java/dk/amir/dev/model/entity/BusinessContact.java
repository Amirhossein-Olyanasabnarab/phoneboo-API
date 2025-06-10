package dk.amir.dev.model.entity;

import dk.amir.dev.model.enums.ContactType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor

public class BusinessContact extends Contact{

    private String companyName;

    public BusinessContact(){
        this.setType(ContactType.BUSINESS);
    }

}
