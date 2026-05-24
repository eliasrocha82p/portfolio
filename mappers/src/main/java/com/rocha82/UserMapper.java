package com.rocha82.mapper;

import com.rocha82.dto.UserDTO;
import com.rocha82.dao.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Se os nomes dos campos forem iguais, o MapStruct faz automático
    UserDTO toDTO(UserModel user);

    // Exemplo de como ignorar a senha ao mapear do DTO para a Entidade
  //  @Mapping(target = "senha", ignore = true)
    UserModel toEntity(UserDTO dto);
}

/*
public record UserDTO(
    int id,
    //String cpf,
    String name*//* ,
    LocalDate birthday,
    LocalDateTime createdAt,
    LocalDateTime updateAt*//*){
   
    
   /* public UserDTO{
    /*    java.util.Objects.requireNonNull(name, "Peson name can not be null");
         java.util.Objects.requireNonNull(id, "Peson id can not be null");
       // java.util.Objects.requireNonNull(cpf,"User cpf can not be null");
    }
   // public UserDTO(int id,/*String cpf, *//*String name){
   //     this(id,/*cpf,name/* ,LocalDate.ofEpochDay(0),LocalDateTime.now(),LocalDateTime.now()*///);
   // }
//}
 
    
    
