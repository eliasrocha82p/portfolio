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
public class UserResponseDTO extends UserAbstractDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
}