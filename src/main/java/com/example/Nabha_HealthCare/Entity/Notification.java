package com.example.Nabha_HealthCare.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    private String message;
    private LocalDateTime createdAt;
    private Boolean isRead;
}