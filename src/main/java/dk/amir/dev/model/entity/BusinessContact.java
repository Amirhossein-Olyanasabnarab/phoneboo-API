package dk.amir.dev.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("BUSINESS")
public class BusinessContact extends Contact{

    private String companyName;

    public BusinessContact(String fullName, String phoneNumber, String email, String companyName) {
        super(fullName, phoneNumber, email);
        this.companyName = companyName;
    }
}
