package com.example.Nabha_HealthCare.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long userId;
    private String name;
    private String phone;
    private Character gender;
    private String email;
    private String role;
    private LocalDateTime createdAt;
}
