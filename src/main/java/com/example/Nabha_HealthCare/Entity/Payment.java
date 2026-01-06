package com.example.Nabha_HealthCare.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;


    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;


    private Double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
}