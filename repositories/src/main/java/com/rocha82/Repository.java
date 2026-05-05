package com.rocha82.repository;
import com.rocha82.dto.UserDTO;
public class Repository{
    public UserDTO getUserByID(int id){
        return new UserDTO(2,"rocha");
    }
}