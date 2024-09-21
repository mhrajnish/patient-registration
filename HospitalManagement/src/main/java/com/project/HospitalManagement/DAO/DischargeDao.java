package com.project.HospitalManagement.DAO;

import com.project.HospitalManagement.Model.DischargeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DischargeDao extends JpaRepository<DischargeData,Integer> {

    @Query(value = "SELECT * FROM discharge_data where patient_id  = :id",nativeQuery = true)
    Optional<DischargeData> findBypatientId(@Param("id") Integer id);
}
