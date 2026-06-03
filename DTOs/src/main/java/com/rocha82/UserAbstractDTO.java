package com.rocha82.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class UserAbstractDTO{

    protected String name;
    protected String cpf;
    protected LocalDate birthday;
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