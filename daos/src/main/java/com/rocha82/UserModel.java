package com.rocha82.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;
import jakarta.persistence.Column;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel{
    @Id 
    @GeneratedValue (
        strategy = GenerationType.IDENTITY)
    private Integer id;
    //String cpf,
    private String name;
    @Column(name="createdat",insertable=false,updatable=false)
    @Generated(event=EventType.INSERT)
    private Instant createdat;
    private Instant updatedat;
    private String cpf;
    private Instant birthday;
    private String mainphonenumber;// TEXT NOT NULL,
    private String maincontact;// TEXT NOT NULL,
    private String phonenumber;// TEXT,
    private String contact;// TEXT,
    private String email;// TEXT NOT NULL UNIQUE,
    private String zipcode;
    private String street;
    private String neighborhood;
    private String city;
    private String passwordhash;
    @PrePersist
    protected void onCreate(){
        this.createdat=Instant.now();
        this.updatedat=Instant.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedat=Instant.now();
    }
}