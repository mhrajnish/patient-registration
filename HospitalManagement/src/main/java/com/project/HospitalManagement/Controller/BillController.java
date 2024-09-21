package com.project.HospitalManagement.Controller;

import com.project.HospitalManagement.Model.Bill;
import com.project.HospitalManagement.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("billing")
public class BillController {

    @Autowired
    BillingService billingService;

    @PutMapping("add")
    public ResponseEntity<String> addBill(@RequestParam Integer id,@RequestParam Long amount) {
       return billingService.addBill(id,amount);
    }

    @GetMapping("get")
    public Long getBill(@RequestParam Integer id) {
        return billingService.getBill(id);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBill(@RequestParam Integer id) {
        return billingService.deleteBill(id);
    }
}
