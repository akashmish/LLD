package com.project.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    //User: Each user should have a userId, name, email.
    private String name;
    private String email;
    @Builder.Default
    private String userId = UUID.randomUUID().toString();
}
