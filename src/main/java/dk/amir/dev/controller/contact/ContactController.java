package dk.amir.dev.controller.contact;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Operation(summary = "contact page", description = "getting welcome message")
    @GetMapping
    public ResponseEntity<?> welcome(){
        return ResponseEntity.ok("Welcome to Contact page");
    }
}
