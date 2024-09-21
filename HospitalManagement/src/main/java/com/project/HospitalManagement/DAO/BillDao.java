package com.project.HospitalManagement.DAO;

import com.project.HospitalManagement.Model.Bill;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {

    @Query(value = "SELECT  * FROM  Bill WHERE patient_id = :id",nativeQuery = true)
    Bill getBill(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Bill WHERE patient_id = :id",nativeQuery = true)
    void deleteBill(@Param("id") Integer patientId);
}
