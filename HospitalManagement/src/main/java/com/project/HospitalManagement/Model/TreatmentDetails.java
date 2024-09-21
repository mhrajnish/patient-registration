package com.project.HospitalManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class TreatmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer treatmentId;

    @NotNull(message = "Patient id cannot be empty")
    private Integer patientId;

    @NotEmpty(message = "Disease cannot be empty")
    private String disease;

}
