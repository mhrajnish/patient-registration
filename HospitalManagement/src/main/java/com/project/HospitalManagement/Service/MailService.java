package com.project.HospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    BillingService billingService;

    public ResponseEntity<String> registrationMailService(String email) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Successful Registration Confirmation");
            message.setText("We are happy to inform you that your registration has been successfully completed. You can now access our services and book appointments at your convenience.\n" +
                    "\n" +
                    "If you have any questions or need further assistance, feel free to reach out to us.\n" +
                    "\n" +
                    "Thank you for choosing our services!\n" +
                    "\n" +
                    "Best regards,\n" +
                    "Hospital Management\n");
            mailSender.send(message);
            return new ResponseEntity<>("Mail Send", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> dischargeMailService(String email,Long amount) {
        try{
           SimpleMailMessage message = new SimpleMailMessage();
           message.setTo(email);
           message.setSubject("Discharge Confirmation");
           message.setText("We are pleased to inform you that you have been successfully discharged. Your medical reports and discharge summary are available for your reference. If you have any follow-up instructions or prescriptions, please ensure to follow them as advised.\n" +
                   "\n" +
                   "If you have any questions or require further assistance, feel free to contact us.\n" +
                   "\n" +
                   "We wish you a speedy recovery and good health ahead!\n" +
                   "\n" +
                   "Total Billing Amount is " + amount + "\n" +
                   "Best regards,\n" +
                   "Hospital Management\n");
           mailSender.send(message);
           return new ResponseEntity<>("Mail Send", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> customMail(String email,String sub, String text) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(sub);
            message.setText(text);
            mailSender.send(message);
            return new ResponseEntity<>("Mail Send", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
