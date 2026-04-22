package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.repository.Repository;
@RestController
public class UsersController{
    @GetMapping("/users")
    public String get(){
        Repository repository = new Repository();
        return repository.getByID(10);
    }
}