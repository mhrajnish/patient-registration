package com.project.HospitalManagement.DAO;

import com.project.HospitalManagement.Model.TreatmentDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentDetailsDao extends JpaRepository<TreatmentDetails, Integer> {
    @Query(value = "SELECT * FROM treatment_details WHERE patient_id = :id",nativeQuery = true)
    Optional<TreatmentDetails> findByPatientId(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE treatment_details SET disease = :dis WHERE patient_id = :id ",nativeQuery = true)
    void update(@Param("id") Integer patientId,@Param("dis") String disease);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM treatment_details WHERE patient_id = :id AND disease = :dis",nativeQuery = true)
    void deleteDetails(@Param("id") Integer patientId,@Param("dis") String disease);
}
