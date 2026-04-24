package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.dto.UserDTO;
@RestController
public class UsersController{
    @GetMapping("/user/{id}")
    public String get(){
        UserDTO userDTO = new UserDTO();
        return userDTO.getByID(10);
    }
}