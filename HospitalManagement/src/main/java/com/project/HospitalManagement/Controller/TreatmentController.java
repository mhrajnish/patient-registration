package com.project.HospitalManagement.Controller;

import com.project.HospitalManagement.Model.TreatmentDetails;
import com.project.HospitalManagement.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("treat")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @PutMapping("add")
    public ResponseEntity<String> addTreatmentDetails(@RequestParam Integer patientId,@RequestParam String disease){
        return treatmentService.addTreatmentDetails(patientId,disease);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateDetails(@RequestParam Integer patientId,@RequestParam String disease){
       return treatmentService.update(patientId,disease);
    }

    @PutMapping("delete")
    public ResponseEntity<String> deleteDetails(@RequestParam Integer patientId,@RequestParam String disease){
        return treatmentService.deleteDetails(patientId,disease);
    }
}
