package com.rocha82.repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
public record Person(
    int id,
    String cpf,
    String name,
    LocalDate birthday,
    LocalDateTime createdAt,
    LocalDateTime updateAt
){  
    public Person{
        java.util.Objects.requireNonNull(name, "Peson name can not be null");
        java.util.Objects.requireNonNull(cpf,"Person cpf can not be null");
    }
    public Person(String cpf, String name){
        this(0,cpf,name,LocalDate.ofEpochDay(0),LocalDateTime.now(),LocalDateTime.now());
    }
}