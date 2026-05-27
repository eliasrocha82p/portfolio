package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.service.UserService;
import com.rocha82.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UsersController{
    private final UserService us;
    public UsersController(UserService u){
        this.us=u;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable int id){
      return us.findById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> users =us.findAll();
        return ResponseEntity.ok(users);
    }
}