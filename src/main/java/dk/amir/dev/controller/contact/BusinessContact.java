package dk.amir.dev.controller.contact;

import dk.amir.dev.dto.BusinessContactDto;
import dk.amir.dev.dto.PersonalContactDto;
import dk.amir.dev.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/business")
public class BusinessContact {

    private final ContactService service;
    @Autowired
    public BusinessContact(ContactService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new business contact")
    @PostMapping
    public ResponseEntity<BusinessContactDto> createContact(@Valid @RequestBody BusinessContactDto dto) {
        return ResponseEntity.ok(service.createBusinessContact(dto));
    }

    @Operation(summary = "Get a  business contact by Id")
    @GetMapping("/{id}")
    public ResponseEntity<BusinessContactDto> getBusinessContact(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getBusinessContactById(id));
    }

    @Operation(summary = "Get all business contacts")
    @GetMapping
    public ResponseEntity<List<BusinessContactDto>> getAllContacts(){
        return ResponseEntity.ok(service.getBusinessContacts());
    }
    @Operation(summary = "updating a business contact")
    @PostMapping("/{id}")
    public ResponseEntity<BusinessContactDto> updateContact(@PathVariable Long id, @Valid @RequestBody BusinessContactDto dto) {
        return ResponseEntity.ok(service.updateBusinessContact(id, dto));
    }
}
