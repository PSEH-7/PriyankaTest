package com.sapient.test.teamstanding.service;

import com.sapient.test.teamstanding.dto.TeamStanding;
import com.sapient.test.teamstanding.exception.BaseException;

public interface TeamService {

    TeamStanding getTeamStanding(String countryName, String leagueName, String teamName) throws BaseException;
}
