package com.rocha82.service;

import com.rocha82.repository.UserRepository;
import com.rocha82.dao.UserModel;
import com.rocha82.dto.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    private UserResponseDTO toUserDTO(UserModel userModel) {
        return UserResponseDTO.builder()
            .id(userModel.getId())
            .createdAt(userModel.getCreatedAt())
            .updatedAt(userModel.getUpdatedAt())
            .name(userModel.getName())
            .cpf(userModel.getCpf())
            .birthday(userModel.getBirthday())
            .email(userModel.getEmail())
            .mainPhoneNumber(userModel.getMainPhoneNumber())
            .mainContact(userModel.getMainContact())
            .phoneNumber(userModel.getPhoneNumber())
            .contact(userModel.getContact())
            .zipCode(userModel.getZipCode())
            .street(userModel.getStreet())
            .neighborhood(userModel.getNeighborhood())
            .city(userModel.getCity())
            .build();
    }

    public Optional<UserResponseDTO> findById(int id) {
        return userRepository.findById(id).map(this::toUserDTO);
    }
    public UserResponseDTO delete(int id) {
        UserResponseDTO userDTO=userRepository.findById(id)
        .map(this::toUserDTO)
        .orElseThrow(()->new IllegalArgumentException("usuario não encontrado"));
        userRepository.deleteById(id);
        return userDTO;
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream().map(this::toUserDTO).toList();
    }

    private UserModel toUserModel(UserAbstractDTO userDTO) {
        var builder = UserModel.builder()
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

        if (userDTO instanceof UserRequestDTO userRequestDTO) {
            builder.password(userRequestDTO.getPassword());
        }

        return builder.build();
    }

    public UserResponseDTO create(UserRequestDTO user) {
        UserModel savedUser = userRepository.save(toUserModel(user));
        return toUserDTO(savedUser);
    }
}
