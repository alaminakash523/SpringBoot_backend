package com.akash.portfolio.service;

import com.akash.portfolio.dao.WorksDao;
import com.akash.portfolio.model.MyWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService
{
    @Autowired
    WorksDao worksDao;


    public ResponseEntity<List<MyWorks>> getAllWorks() {
        return new ResponseEntity<>(worksDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<MyWorks> getWorksById(int workId) {
        return new ResponseEntity<>(worksDao.findById(workId).get(), HttpStatus.OK);
    }


    public ResponseEntity<String> updateWork(MyWorks myWorks) {
        try {
            worksDao.save(myWorks);
            return new ResponseEntity<>("Work Updated.",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteWork(int workId) {
        MyWorks myWorks = worksDao.findById(workId).get();
        if (myWorks == null) {
            return new ResponseEntity<>("Work Not Found",HttpStatus.NOT_FOUND);
        }else {
            worksDao.delete(myWorks);
            return new ResponseEntity<>("Work Deleted",HttpStatus.OK);
        }
    }

    public ResponseEntity<String> addWork(MyWorks myWorks) {
        worksDao.save(myWorks);
        return new ResponseEntity<>("Work Added",HttpStatus.OK);
    }
}
