package dk.amir.dev.controller.contact;



import dk.amir.dev.dto.ContactDto;
import dk.amir.dev.facade.ContactFacade;
import dk.amir.dev.model.entity.Contact;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactFacade facade;
    @Autowired
    public ContactController(ContactFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    @Operation(summary = "Get All Contacts", description = "Returns a list of all contacts.")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> contacts= facade.getAllContacts();
        return  ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get A Contact By Id", description = "Returns a contact.")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = facade.getContactById(id);
        return  ResponseEntity.ok(contactDto);
    }

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto contactDto) {
        ContactDto newContactDto = facade.addContact(contactDto);
        return  ResponseEntity.ok(newContactDto);
    }


}
