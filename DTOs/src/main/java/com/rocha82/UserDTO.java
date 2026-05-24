package com.rocha82.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
/*
public record UsuarioDTO(
    Long id, 
    @NotBlank String nome, 
    @Email String email
) {}

*/
public record UserDTO(
    int id,
    //String cpf,
    @NotBlank
    String name/* ,
    LocalDate birthday,
    LocalDateTime createdAt,
    LocalDateTime updateAt*/){
   
    
   // public UserDTO{
       // java.util.Objects.requireNonNull(name, "Peson name can not be null");
        // java.util.Objects.requireNonNull(id, "Peson id can not be null");
       // java.util.Objects.requireNonNull(cpf,"User cpf can not be null");
  //  }
   // public UserDTO(int id,/*String cpf, */String name){
   //     this(id,/*cpf,*/name/* ,LocalDate.ofEpochDay(0),LocalDateTime.now(),LocalDateTime.now()*/);
   // }
}