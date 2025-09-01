package com.samlportal.samlportal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private UUID id;
    private String message;
    private Instant createdAt;
    private Long userId;
    private String username;
    private String role;
}
