package com.sapient.test.teamstanding.controller;

import com.sapient.test.teamstanding.dto.TeamStanding;
import com.sapient.test.teamstanding.exception.BaseException;
import com.sapient.test.teamstanding.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    private TeamService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/standings")
    public ResponseEntity<TeamStanding> getStandings(@RequestParam final String countryName,
            @RequestParam final String leagueName, @RequestParam final String teamName) throws BaseException {
        TeamStanding teamStanding = service.getTeamStanding(countryName, leagueName, teamName);
        return new ResponseEntity<>(teamStanding, HttpStatus.OK);
    }
}
