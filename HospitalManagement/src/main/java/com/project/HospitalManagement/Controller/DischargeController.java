package com.project.HospitalManagement.Controller;

import com.project.HospitalManagement.Service.DischargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("discharge")
public class DischargeController {

    @Autowired
    DischargeService dischargeService;

    @PutMapping("add")
    public ResponseEntity<String> discharge (@RequestParam Integer id) {
        return dischargeService.addDetails(id);
    }

    @GetMapping("get")
    public ResponseEntity<String> getDischarge (@RequestParam Integer id) {
        return dischargeService.getDischarge(id);
    }

    @PutMapping("delete")
    public ResponseEntity<String> deleteDischarge(@RequestParam Integer id) {
        return dischargeService.deleteDischarge(id);
    }
}

