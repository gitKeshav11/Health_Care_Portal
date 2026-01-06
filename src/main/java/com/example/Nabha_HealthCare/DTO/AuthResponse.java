package com.example.Nabha_HealthCare.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private UserResponse user;
    private List<String> permissions; // e.g., ["VIEW_DOCTORS","BOOK_APPOINTMENT"]
    private String message;
}