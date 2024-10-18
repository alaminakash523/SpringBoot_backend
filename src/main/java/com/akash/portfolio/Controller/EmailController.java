package com.akash.portfolio.Controller;

import com.akash.portfolio.model.Emails;
import com.akash.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String email() {
        return "email";
    }

    @GetMapping("/get-emails")
    public ResponseEntity<List<Emails>> getAllEmail(){
        return emailService.getAllEmail();
    }

    @PostMapping("/send-emails")
    public ResponseEntity<String> sendEmail(@RequestBody Emails email) {
        return emailService.addEmail(email);
    }

    @GetMapping("get-mail/{emailId}")
    public ResponseEntity<Emails> getMail(@PathVariable int emailId) {
        return emailService.getMailByID(emailId);
    }

}
