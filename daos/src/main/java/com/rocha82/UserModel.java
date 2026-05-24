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