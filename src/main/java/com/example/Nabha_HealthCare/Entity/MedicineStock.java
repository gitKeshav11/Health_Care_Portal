package com.example.Nabha_HealthCare.Entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="medicine_stock")
public class MedicineStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    private Long totalStock;


    @ManyToOne
    @JoinColumn(name="medicine_id")
    private Medicine medicine;


    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
}