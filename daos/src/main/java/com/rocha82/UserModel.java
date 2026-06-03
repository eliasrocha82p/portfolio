package com.rocha82.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserModel {
    
    private final static int NAME_LENGTH=3;
    
    private final static int CPF_LENGTH=11;
    
    public static class UserModelBuilder{
        private String name;
        private String cpf;
        private Instant birthday;
        private String mainPhoneNumber;
        private String mainContact;
        private String phoneNumber;
        private String contact;
        private String email;
        private String zipCode;
        private String street;
        private String neighborhood;
        private String city;
        private Integer id;
        private String password;
        
        public UserModelBuilder name(String name){
            this.name=name;
            return this;
        }
        public UserModelBuilder cpf(String cpf){
            this.cpf=cpf;
            return this;
        }
        public UserModelBuilder birthday(Instant birthday){
            this.birthday=birthday;
            return this;
        }
        public UserModelBuilder mainPhoneNumber(String mainPhoneNumber){
            this.mainPhoneNumber=mainPhoneNumber;
            return this;
        }
        public UserModelBuilder mainContact(String mainContact){
            this.mainContact=mainContact;
            return this;
        }
        public UserModelBuilder phoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }
        public UserModelBuilder contact(String contact){
            this.contact=contact;
            return this;
        }
        public UserModelBuilder email(String email){
            this.email=email;
            return this;
        }
        public UserModelBuilder zipCode(String zipCode){
            this.zipCode=zipCode;
            return this;
        }
        public UserModelBuilder street(String street){
            this.street=street;
            return this;
        }
        public UserModelBuilder neighborhood(String neighborhood){
            this.neighborhood=neighborhood;
            return this;
        }
        public UserModelBuilder city(String city){
            this.city=city;
            return this;
        }
        public UserModelBuilder password(String password){
            this.password=password;
            return this;
        }
        
   /*     public UserModel build(){
            UserModel user=new UserModel(this.email,this.mainContact,this.mainPhoneNumber);
            user.setName(this.name);
            user.setCpf(this.cpf);
            user.setPassword(this.password);
            user.setZipCode(this.zipCode);
            user.setNeighborhood(this.neighborhood);
            user.setCity(this.city);
            user.setBirthday(this.birthday);
            user.setMainPhoneNumber(this.mainPhoneNumber);
            user.setPhoneNumber(this.phoneNumber);
            user.setStreet(this.street);
            user.setContact(this.contact);

            return user;
        }*/
        public UserModel build() {
            return new UserModel(this);
        }
    }
    
    public static UserModelBuilder builder(){
        return new UserModelBuilder();
    }
    private UserModel(UserModelBuilder builder) {
        // Usamos as validações obrigatórias através dos setters inteligentes
        setName(builder.name);
        setCpf(builder.cpf);
        setPassword(builder.password);

        // Atributos comuns recebem atribuição direta
        this.email = builder.email;
        this.mainContact = builder.mainContact;
        this.mainPhoneNumber = builder.mainPhoneNumber;
        this.phoneNumber = builder.phoneNumber;
        this.contact = builder.contact;
        this.zipCode = builder.zipCode;
        this.street = builder.street;
        this.neighborhood = builder.neighborhood;
        this.city = builder.city;
        this.birthday = builder.birthday;
    }
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false)
    private String name;
    public void setName(String name){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou estar vazio!");
        }
        if(name.length()<NAME_LENGTH){
            throw new IllegalArgumentException("O nome precisa ter pelo menos "+NAME_LENGTH+" "+"caracteres!");
        }
        this.name=name;
    }
    @Column(nullable = false, unique = true, length = CPF_LENGTH)
    private String cpf;
    public void setCpf(String cpf){
        if(cpf==null||cpf.isBlank()){
            throw new IllegalArgumentException("O CPF não pode ser nulo e precisa ter 11 dígitos!");
        }
        if(cpf.length()!=CPF_LENGTH){
            throw new IllegalArgumentException("O CPF precisar ter 11 digitos!");
        }
        this.cpf=cpf;
    }

    @Column(name = "createdat", updatable = false)
    @Setter(AccessLevel.NONE)
    private Instant createdAt;
    @Column(name = "updatedat")
    @Setter(AccessLevel.NONE)
    private Instant updatedAt;

    private Instant birthday;

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
    private String neighborhood; // Corrigido o erro de digitação
    private String city;

    private String encriptPassword(String password){

        return password +"encripted";
    }
    @Column(name = "passwordhash", nullable = false)
    @Setter(AccessLevel.NONE)
    private String passwordHash;
    public void setPassword(String password){
        if(password==null||password.isBlank()){
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia!");
        }
        if(password.length()<8){
            throw new IllegalArgumentException("A senha precisa ter ao menos 8 caracteres");
        }
        this.passwordHash=encriptPassword(password);
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
