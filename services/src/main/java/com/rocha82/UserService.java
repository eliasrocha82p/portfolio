package com.rocha82.service;
import com.rocha82.repository.UserRepository;
import com.rocha82.dao.UserModel;
import com.rocha82.dto.*;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService{
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    private UserResponseDTO  toUserDTO(UserModel userModel){
        return UserResponseDTO.builder()
        .id(userModel.getId())
        .name(userModel.getName())
        cpf(userModel.getCpf())
        .build();
    }
    public Optional<UserResponseDTO> findById(int id){
        return userRepository.findById(id).map(this::toUserDTO);
    }
    public List<UserResponseDTO> findAll(){
        return userRepository.findAll().stream().map(this::toUserDTO).toList();
    }
   private UserModel toUserModel(UserAbstractDTO userDTO){
       UserModel.UserModelBuilder builder=UserModel.builder()
       .name(userDTO.getName())
       .cpf(userDTO.getCpf())
       .birthday(userDTO.getBirthday())
       .mainPhoneNumber(userDTO.getMainPhoneNumber())
       .mainContact(userDTO.getMainContact())
       .phoneNumber(userDTO.getPhoneNumber())
       .contact(userDTO.getContact())
       .email(userDTO.getEmail())
       .zipCode(userDTO.getZipCode())
       .street(userDTO.getStreet())
       .neighborhood(userDTO.getNeighborhood())
       .city(userDTO.getCity());
       if (userDTO instanceof UserRequestDTO userRequestDTO){
           builder.password(userRequestDTO.getPassword());
       }
       return builder.build();
   }
    public UserResponseDTO create(UserRequestDTO user){
        UserModel savedUser=userRepository.save(toUserModel(user));
        return toUserDTO(savedUser);
        
    }
}