package com.example.Nabha_HealthCare.DTO;

import lombok.Data;

@Data
public class HospitalRequest {
    private String name;
    private String address;
    private String phoneNumber;
    private Long adminId;
}