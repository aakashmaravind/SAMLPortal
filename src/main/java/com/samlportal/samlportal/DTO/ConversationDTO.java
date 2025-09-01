package com.samlportal.samlportal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ConversationDTO {
    private UUID id;
    private String message;
    private Instant createdAt;
    private Long userId;
    private String username;
    private String role;
    private List<ReplyDTO> replies;
}
