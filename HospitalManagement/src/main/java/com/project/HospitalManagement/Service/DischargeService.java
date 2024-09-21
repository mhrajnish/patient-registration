package com.project.HospitalManagement.Service;

import com.project.HospitalManagement.DAO.DischargeDao;
import com.project.HospitalManagement.Model.DischargeData;
import com.project.HospitalManagement.Model.NewUser;
import com.project.HospitalManagement.Model.TreatmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DischargeService {

    @Autowired
    DischargeDao dischargeDao;

    @Autowired
    RecordService recordService;

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    MailService mailService;

    @Autowired
    BillingService billingService;

    public ResponseEntity<String> addDetails(Integer id) {
        try{
            DischargeData curr = new DischargeData();
            NewUser newUser = recordService.getPatientByID(id);
            TreatmentDetails treatmentDetails = treatmentService.findTreatmentDetailsById(id);
            curr.setPatientId(newUser.getPatientId());
            curr.setPatientName(newUser.getFirstName() + " " + newUser.getLastName());
            curr.setRegistrationDate(newUser.getDate());
            curr.setDisease(treatmentDetails.getDisease());
            dischargeDao.save(curr);
            mailService.dischargeMailService(newUser.getMail(),billingService.getBill(curr.getPatientId()));
            return new ResponseEntity<>("Details added successfully", HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Details Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> getDischarge(Integer id) {
        try{
            Optional<DischargeData> data = dischargeDao.findBypatientId(id);
            if(data.isEmpty()){
                return new ResponseEntity<>("Discharge Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(data.get().toString(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteDischarge(Integer id) {
        try{
            Optional<DischargeData> curr = dischargeDao.findBypatientId(id);
            if(curr.isEmpty()){
                return new ResponseEntity<>("Discharge Not Found", HttpStatus.NOT_FOUND);
            }
            dischargeDao.delete(curr.get());
            return new ResponseEntity<>("Discharge deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
