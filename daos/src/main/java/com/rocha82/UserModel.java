package com.rocha82.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    int id;
    //String cpf,
    String name;
    @Column(name="createdat",insertable=false,updatable=false)
    @Generated(event=EventType.INSERT)
    Instant createdat;
    Instant updatedat;
    String cpf;
    Instant birthday;
    String mainphonenumber;// TEXT NOT NULL,
    String maincontact;// TEXT NOT NULL,
    String phonenumber;// TEXT,
    String contact;// TEXT,
    String email;// TEXT NOT NULL UNIQUE,
    String zipcode;
    String street;
    String neigborhood;
    String city;
    String hash;
    String passwordhash;
    //@PreUpdate
    //protected onUpdate(){
      //  this.updateat=instant.ofEpochSecond(Instant.now().getEpochSecond());
   // }
    /* ,
    LocalDate birthday,
    LocalDateTime createdAt,
    LocalDateTime updateAt*/
   // public UserModel{
    //    java.util.Objects.requireNonNull(name, "Peson name can not be null");
       // java.util.Objects.requireNonNull(cpf,"User cpf can not be null");
  //  public UserModel(/*String cpf, */String name){
    //    this(0,/*cpf,*/name/* ,LocalDate.ofEpochDay(0),LocalDateTime.now(),LocalDateTime.now()*/);
}