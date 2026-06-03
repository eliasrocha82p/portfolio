package com.rocha82.dao;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Seguro para o JPA, inacessível externamente
public class UserModel {
    
    private final static int NAME_LENGTH = 3;
    private final static int CPF_LENGTH = 11;

    // O @Builder no construtor garante que o Lombok use suas validações ao buildar
    @Builder
    private UserModel(String name, String cpf, LocalDate birthday, String mainPhoneNumber, 
                      String mainContact, String phoneNumber, String contact, String email, 
                      String zipCode, String street, String neighborhood, String city, String password) {
        setName(name);
        setCpf(cpf);
        setPassword(password);
        this.birthday = birthday;
        this.mainPhoneNumber = mainPhoneNumber;
        this.mainContact = mainContact;
        this.phoneNumber = phoneNumber;
        this.contact = contact;
        this.email = email;
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    private String name;

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        if (name.length() < NAME_LENGTH) throw new IllegalArgumentException("O nome precisa ter ao menos " + NAME_LENGTH + " caracteres!");
        this.name = name;
    }

    @Column(nullable = false, unique = true, length = CPF_LENGTH)
    private String cpf;

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("O CPF não pode ser nulo!");
        if (cpf.length() != CPF_LENGTH) throw new IllegalArgumentException("O CPF precisa ter 11 dígitos!");
        this.cpf = cpf;
    }

    @Column(name = "createdat", updatable = false)
    @Setter(AccessLevel.NONE)
    private Instant createdAt;

    @Column(name = "updatedat")
    @Setter(AccessLevel.NONE)
    private Instant updatedAt;

    private LocalDate birthday;

    @Column(name = "mainphonenumber", nullable = false)
    private String mainPhoneNumber;

    @Column(name = "maincontact", nullable = false)
    private String mainContact;
    
    @Column(name = "phonenumber")
    private String phoneNumber;
    private String contact;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "zipcode")
    private String zipCode;
    
    private String street;
    private String neighborhood; 
    private String city;

    @Column(name = "passwordhash", nullable = false)
    @Setter(AccessLevel.NONE)
    private String passwordHash;

    public void setPassword(String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("A senha não pode ser nula ou vazia!");
        if (password.length() < 8) throw new IllegalArgumentException("A senha precisa ter ao menos 8 caracteres");
        this.passwordHash = encriptPassword(password);
    }

    private String encriptPassword(String password) {
        return password + "encripted"; // Substituir por BCrypt futuramente
    }

    @PrePersist
    protected void onCreate() { this.createdAt = Instant.now(); this.updatedAt = Instant.now(); }

    @PreUpdate
    protected void onUpdate() { this.updatedAt = Instant.now(); }
}
