package dk.amir.dev.model.entity;

import dk.amir.dev.model.enums.ContactType;

public abstract class Contact {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private ContactType contactType;
    private Boolean deleted;
}
