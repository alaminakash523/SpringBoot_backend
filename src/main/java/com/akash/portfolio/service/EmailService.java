package com.akash.portfolio.service;

import com.akash.portfolio.dao.EmailsDao;
import com.akash.portfolio.model.Emails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailsDao emailsDao;

    public ResponseEntity<List<Emails>> getAllEmail() {
        return new ResponseEntity<>(emailsDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addEmail(Emails email) {
        emailsDao.save(email);
        return new ResponseEntity<>("Email Sent.",HttpStatus.OK);
    }

    public ResponseEntity<Emails> getMailByID(int emailId) {
        return new ResponseEntity<>(emailsDao.findById(emailId).get(), HttpStatus.OK);
    }
}
