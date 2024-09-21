package com.project.HospitalManagement.Service;

import com.project.HospitalManagement.DAO.TreatmentDetailsDao;
import com.project.HospitalManagement.Model.TreatmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentService {
    @Autowired
   TreatmentDetailsDao treatmentDetailsDao;

    public ResponseEntity<String> addTreatmentDetails(Integer patientId,String disease) {
        try{
            TreatmentDetails treatmentDetails = new TreatmentDetails();
            treatmentDetails.setPatientId(patientId);
            treatmentDetails.setDisease(disease);
            treatmentDetailsDao.save(treatmentDetails);
            return new ResponseEntity<>("Successfully added Treatment Details", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public TreatmentDetails findTreatmentDetailsById(Integer id) {
        try{
          Optional<TreatmentDetails> curr = treatmentDetailsDao.findByPatientId(id);
          return curr.orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    public ResponseEntity<String> update(Integer patientId, String disease) {
        try{
            treatmentDetailsDao.update(patientId,disease);
            return new ResponseEntity<>("Successfully updated Treatment Details", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteDetails(Integer patientId, String disease) {
        try{
            treatmentDetailsDao.deleteDetails(patientId,disease);
            return new ResponseEntity<>("Successfully deleted Treatment Details", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
