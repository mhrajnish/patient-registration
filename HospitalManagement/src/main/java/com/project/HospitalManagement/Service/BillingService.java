package com.project.HospitalManagement.Service;

import com.project.HospitalManagement.DAO.BillDao;
import com.project.HospitalManagement.Model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    BillDao billDao;

    public ResponseEntity<String> addBill(Integer patientId,Long amount) {
        try{
            Bill bill = new Bill();
            bill.setPatientId(patientId);
            bill.setTotalAmount(amount);
            billDao.save(bill);
            return new ResponseEntity<>("Bill added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Long getBill(Integer id) {
        try{
            Bill bill = billDao.getBill(id);
            return bill.getTotalAmount();
        }catch (Exception e){
            return null;
        }
    }

    public ResponseEntity<String> deleteBill(Integer patientId) {
        try{
            billDao.deleteBill(patientId);
            return new ResponseEntity<>("Bill deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
