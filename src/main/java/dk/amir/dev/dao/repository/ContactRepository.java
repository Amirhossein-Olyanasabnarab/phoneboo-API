package dk.amir.dev.dao.repository;

import dk.amir.dev.model.entity.Contact;
import dk.amir.dev.model.enums.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
