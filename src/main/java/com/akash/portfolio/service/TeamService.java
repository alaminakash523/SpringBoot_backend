package com.akash.portfolio.service;

import com.akash.portfolio.dao.TeamDao;
import com.akash.portfolio.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamDao teamDao;

    public ResponseEntity<List<Team>> getAllMember() {
        return new ResponseEntity<>(teamDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addMember(Team team) {
        try {
            teamDao.save(team);
            return new ResponseEntity<>("New Member Created.",HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> dropMember(Integer teamId) {
        Team member = teamDao.findById(teamId).get();

        try {
            if (member == null){
                return new ResponseEntity<>("Member not found",HttpStatus.NOT_FOUND);
            }else {
                teamDao.delete(member);
                return new ResponseEntity<>("Member Deleted.", HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Team> getMember(int memberId) {
        return new ResponseEntity<>(teamDao.findById(memberId).get(), HttpStatus.OK);
    }

    public ResponseEntity<Team> getSingleMember(String memberName) {
        System.out.println(memberName);
        Team member = teamDao.findByName(memberName);
        System.out.println(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
