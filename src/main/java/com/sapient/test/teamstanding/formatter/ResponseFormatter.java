package com.sapient.test.teamstanding.formatter;

import com.sapient.test.teamstanding.dto.Country;
import com.sapient.test.teamstanding.dto.Standing;
import com.sapient.test.teamstanding.dto.TeamStanding;
import org.springframework.stereotype.Component;

@Component
public class ResponseFormatter {

    public TeamStanding format(Country country, Standing standing) {
        TeamStanding teamStanding = new TeamStanding();
        teamStanding.setCountryId(country.getCountryId());
        teamStanding.setCountryName(country.getCountryName());
        teamStanding.setLeagueId(standing.getLeague_id());
        teamStanding.setLeagueName(standing.getLeague_name());
        teamStanding.setTeamId(standing.getTeam_id());
        teamStanding.setTeamName(standing.getTeam_name());
        teamStanding.setOverallStandingPosition(standing.getOverall_league_position());
        return teamStanding;
    }
}
