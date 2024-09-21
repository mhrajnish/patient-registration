package com.project.HospitalManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class DischargeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dischargeId;

    @NotNull(message = "Patient id cannot be empty")
    private Integer patientId;

    @NotEmpty(message = "Patient name cannot be empty")
    private String patientName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dischargeDate;

    @NotNull(message = "Registration date cannot be empty")
    private Date registrationDate;

    @NotEmpty(message = "Disease cannot be empty")
    private String disease;

}
