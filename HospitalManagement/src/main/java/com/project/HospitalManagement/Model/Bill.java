package com.project.HospitalManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Bill {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer billId;

    @NotNull(message = "Patient Id cannot be null")
    private Integer patientId;

    @NotNull(message = "Billing amount cannot be empty")
    private Long totalAmount;
}
