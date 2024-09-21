package com.project.HospitalManagement.Controller;

import com.project.HospitalManagement.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    MailService mailService;

    @PutMapping("register")
    public ResponseEntity<String> registration(@RequestParam String email){
        return mailService.registrationMailService(email);
    }

    @PutMapping("discharge")
    public ResponseEntity<String> dischargeMail(@RequestParam String email){
        return mailService.dischargeMailService(email,(long)0);
    }

    @PutMapping("custom")
    public ResponseEntity<String> customMail(@RequestParam String email,@RequestParam String sub ,@RequestParam String text){
        return mailService.customMail(email,sub,text);
    }
}
