package com.rocha82.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class UserRequestDTO extends UserAbstractDTO{
    
    private String password;
    
}