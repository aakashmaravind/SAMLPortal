package com.samlportal.samlportal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostReq {
    private Long userId;
    private UUID parentId;
    private String message;
}
