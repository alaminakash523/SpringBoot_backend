package com.akash.portfolio.Controller;


import com.akash.portfolio.model.Team;
import com.akash.portfolio.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/get_all_member")
    public ResponseEntity<List<Team>> getTeamMember() {
        return teamService.getAllMember();
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Team> getMember(@PathVariable int memberId) {
        return teamService.getMember(memberId);
    }
    @GetMapping("/single_member/{memberName}")
    public ResponseEntity<Team> getSingleMember(@PathVariable String memberName) {
        return teamService.getSingleMember(memberName);
    }

    @PostMapping("/add_team_member")
    public ResponseEntity<String> addTeamMember(@RequestBody Team team) {
        return teamService.addMember(team);
    }

    @PutMapping("/update_member")
    public ResponseEntity<String> updateTeamMember(@RequestBody Team team) {
        return teamService.addMember(team);
    }

    @DeleteMapping("/delete_member/{teamId}")
    public ResponseEntity<String> deleteTeamMember(@PathVariable Integer teamId) {
        return teamService.dropMember(teamId);
    }

}
