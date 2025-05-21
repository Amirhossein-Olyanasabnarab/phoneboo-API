package dk.amir.dev.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Operation(summary = "home page", description = "index page")
    @GetMapping
    public String home() {
        return "Welcome to Phonebook APIs";
    }
}
