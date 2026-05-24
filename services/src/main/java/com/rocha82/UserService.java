package com.rocha82.service;
import com.rocha82.repository.UserRepository;
import com.rocha82.dao.UserModel;
import com.rocha82.dto.UserDTO;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
@Service
public class UserService{
    UserRepository ur;
    public UserService(UserRepository ur){
        this.ur = ur;
    }
    public String get(int id){
        Optional<UserModel> um=ur.findById(id);
        if(!(um.isPresent()))
        return "Usuário não encontrado";
        UserDTO userDTO = new UserDTO(um.get().getId(),um.get().getName());
        return userDTO.toString();
    }
    public String all(){
        ArrayList<UserDTO> users = new ArrayList<>();
        List<UserModel> um=ur.findAll();
        for(UserModel u: um){
            //UserDTO userDTO = new UserDTO(u.get().getId(),u.get().getName());
            users.add(new UserDTO(u.getId(),u.getName()));
        }
        return users.toString();
    }
}