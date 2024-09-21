package com.project.HospitalManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
public class NewUser {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer patientId;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 3,message = "minimum length of first name should be more than 3")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 3,message = "minimum length of last name should be more than 3")
    private String lastName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    @NotEmpty(message = "Patient mobile number is required")
    @Size(min = 10,max = 10,message = "Enter valid mobile number")
    private String mobileNumber;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 3,message = "minimum length of first name should be more than 3")
    private String guardianFirstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 3,message = "minimum length of last name should be more than 3")
    private String guardianLastName;

    @NotEmpty(message = "Guardian mobile number is required")
    @Size(min = 10,max = 10,message = "Enter valid mobile number")
    private String guardianMobileNumber;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Enter valid mail id")
    private String mail;
}
