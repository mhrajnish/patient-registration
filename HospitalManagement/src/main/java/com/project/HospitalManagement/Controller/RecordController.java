package com.project.HospitalManagement.Controller;

import com.project.HospitalManagement.Model.NewUser;
import com.project.HospitalManagement.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @PutMapping("new")
    public ResponseEntity<String> newPatientRegistration(@RequestBody NewUser newUser){
        return  recordService.newPatientRegistration(newUser);
    }

    @GetMapping("get")
    public ResponseEntity<String> getPatientDetails(@RequestParam Integer id){
        return recordService.getPatientDetails(id);
    }

}
