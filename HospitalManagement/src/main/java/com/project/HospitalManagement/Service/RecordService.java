package com.project.HospitalManagement.Service;

import com.project.HospitalManagement.DAO.NewPatientDao;
import com.project.HospitalManagement.Model.NewUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class RecordService {

    @Autowired
    NewPatientDao newPatientDao;

    @Autowired
    MailService mailService;

    public ResponseEntity<String> newPatientRegistration(NewUser newUser) {
        try{
            mailService.registrationMailService(newUser.getMail());
            newPatientDao.save(newUser);
            return new ResponseEntity<>("Patient details registered successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> getPatientDetails(Integer patientId) {
        try{
            Optional<NewUser> user = newPatientDao.getByPatientId(patientId);
            if(user.isEmpty()){
                return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
            }
             return new ResponseEntity<>(user.get().toString(), HttpStatus.OK);
        }catch (EntityNotFoundException e){
             return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
        }catch (Exception e){
             return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deletePatient(Integer patientId) {
        try{
           Optional<NewUser> user = newPatientDao.getByPatientId(patientId);
           if(user.isEmpty()){
               return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
           }
            newPatientDao.delete(user.get());
            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>("Patient not found", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public NewUser getPatientByID(Integer patientId) {
        try{
            Optional<NewUser> user = newPatientDao.getByPatientId(patientId);
            return user.orElse(null);
        }catch (Exception e){
            return null;
        }
    }

}
