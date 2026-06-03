package com.rocha82.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocha82.service.UserService;
import com.rocha82.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/users")
public class UsersController{
    private final UserService us;
    public UsersController(UserService u){
        this.us=u;
    }
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO user){
        UserResponseDTO userDTO = us.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable int id){
      return us.findById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> users =us.findAll();
        return ResponseEntity.ok(users);
    }
}