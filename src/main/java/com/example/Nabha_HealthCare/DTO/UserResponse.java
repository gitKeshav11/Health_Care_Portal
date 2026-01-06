package com.example.Nabha_HealthCare.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String name;
    private String phone;
    private Character gender;
    private String email;
    private String role;
    private LocalDateTime createdAt;
}