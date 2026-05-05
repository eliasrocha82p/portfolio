package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.service.UserService;
import com.rocha82.dto.UserDTO;

@RestController
public class UsersController{
    @GetMapping("/user/{id}")
    public String get(){
        UserService userService = new UserService();
        return userService.get(23,"Mel Soares").toString();
    }
}