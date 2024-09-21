package com.project.HospitalManagement.DAO;

import com.project.HospitalManagement.Model.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewPatientDao extends JpaRepository<NewUser,Integer> {

    @Query(value = "SELECT * FROM new_user WHERE patient_id  = :id",nativeQuery = true)
    Optional<NewUser> getByPatientId(@Param("id") Integer patientId);
}
