package dk.amir.dev.controller.contact;

import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/personal")
public class PersonalContact {

    private final ContactService service;
    @Autowired
    public PersonalContact(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PersonalContactDto> createContact(@Valid @RequestBody PersonalContactDto dto) {
        return ResponseEntity.ok(service.createPersonalContact(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalContactDto> getPersonalContact(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getPersonalContactById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonalContactDto>> getAllContacts(){
        return ResponseEntity.ok(service.getPersonalContacts());
    }

    @PostMapping("/{id}")
    public ResponseEntity<PersonalContactDto> updateContact(@PathVariable Long id, @Valid @RequestBody PersonalContactDto dto) {
        return ResponseEntity.ok(service.updatePersonalContact(id, dto));
    }


}
