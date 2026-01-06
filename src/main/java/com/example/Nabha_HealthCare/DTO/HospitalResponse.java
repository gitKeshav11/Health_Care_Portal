package com.example.Nabha_HealthCare.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {

    private Long hospitalId;
    private String name;
    private String address;
    private String phoneNumber;

    private Long adminId;
    private String adminName;
}
