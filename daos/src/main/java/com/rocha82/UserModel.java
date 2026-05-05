package com.rocha82.dao;
public record UserModel(
    int id,
    //String cpf,
    String name/* ,
    LocalDate birthday,
    LocalDateTime createdAt,
    LocalDateTime updateAt*/
){  
    public UserModel{
        java.util.Objects.requireNonNull(name, "Peson name can not be null");
       // java.util.Objects.requireNonNull(cpf,"User cpf can not be null");
    }
    public UserModel(/*String cpf, */String name){
        this(0,/*cpf,*/name/* ,LocalDate.ofEpochDay(0),LocalDateTime.now(),LocalDateTime.now()*/);
    }
}