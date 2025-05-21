package dk.amir.dev.controller.contact;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    public ResponseEntity<?> welcome(){
        return ResponseEntity.ok("Welcome to Contact page");
    }
}
