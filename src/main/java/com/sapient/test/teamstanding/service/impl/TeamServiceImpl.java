package com.sapient.test.teamstanding.service.impl;

import com.sapient.test.teamstanding.constants.Constant;
import com.sapient.test.teamstanding.dto.*;
import com.sapient.test.teamstanding.exception.BaseException;
import com.sapient.test.teamstanding.formatter.ResponseFormatter;
import com.sapient.test.teamstanding.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResponseFormatter formatter;

    @Override
    public TeamStanding getTeamStanding(String countryName, String leagueName, String teamName) throws BaseException {
        Country country = getCountryDetails(countryName);
        if(country == null) {
            throw new BaseException("No data found");
        }
        League league = getLeagueDetails(country.getCountryId(), leagueName);
        if(league == null) {
            throw new BaseException("No data found");
        }
        Standing standing = getStandingDetails(league.getLeagueId(), teamName);

        if(standing == null) {
            throw new BaseException("No data found");
        }

        return formatter.format(country, standing);
    }

    private Country getCountryDetails(String country) {
        String url = Constant.COUNTRY_URL + Constant.API_KEY;
        Country[] response = restTemplate.getForObject(url, Country[].class);
        if(response == null) {
            return null;
        }
        Country found = null;

        for(Country c : response) {
         if(c.getCountryName().equals(country)) {
             found = c;
             break;
         }
        }
        return found;
    }

    private League getLeagueDetails(String countryId, String leagueName) {
        String url = Constant.LEAGUE_URL + countryId + "&APIkey="+ Constant.API_KEY;
        League[] response = restTemplate.getForObject(url, League[].class);
        if(response == null) {
            return null;
        }
        League found = null;

        for (League league : response) {
            if (league.getLeagueName().equals(leagueName)) {
               found = league;
               break;
            }
        }
        return found;
    }

    private Standing getStandingDetails(String leagueId, String teamName) {
        String url = Constant.STANDING_URL + leagueId + "&APIkey="+ Constant.API_KEY;
        Standing[] response = restTemplate.getForObject(url, Standing[].class);
        if(response == null) {
            return null;
        }
        Standing stand = null;

        for (Standing standing : response) {
            if (standing.getTeam_name().equals(teamName)) {
                stand = standing;
                break;
            }
        }
        return stand;
    }
}
