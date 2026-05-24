package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.service.UserService;
//import com.rocha82.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/users")
public class UsersController{
    private final UserService us;
    public UsersController(UserService u){
        this.us=u;
    }
    @GetMapping("/user/{id}")
    public String get(@PathVariable int id){
      return us.get(id);
    }
    @GetMapping("")
    public String all(){
        return us.all();
    }
}