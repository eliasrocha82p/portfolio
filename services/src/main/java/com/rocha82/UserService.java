package com.rocha82.service;
import com.rocha82.repository.Repository;
import com.rocha82.dto.UserDTO;
public class UserService{
    
    public UserDTO get(int id, String name){
        UserDTO userDTO = new UserDTO(id,name);
        return userDTO;
    }
}
 
    
    
