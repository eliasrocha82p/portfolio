package com.rocha82.service;
import com.rocha82.repository.UserRepository;
import com.rocha82.dao.UserModel;
import com.rocha82.dto.UserDTO;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService{
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    private UserDTO toUserDTO(UserModel userModel){
        return new UserDTO(userModel.getId(),userModel.getName());
    }
    public Optional<UserDTO> findById(int id){
        return userRepository.findById(id).map(this::toUserDTO);
    }
    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(this::toUserDTO).toList();
    }
}