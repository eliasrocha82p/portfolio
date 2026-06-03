package com.rocha82.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class UserAbstractDTO{

    protected String name;
    protected String cpf;
    protected Instant birthday;
    protected String mainPhoneNumber;
    protected String mainContact;
    protected String phoneNumber;
    protected String contact;
    protected String email;
    
    protected String zipCode;
    protected String street;
    protected String neighborhood;
    protected String city;
    
}