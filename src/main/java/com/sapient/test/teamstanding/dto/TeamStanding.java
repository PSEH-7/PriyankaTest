package com.sapient.test.teamstanding.dto;

import java.io.Serializable;

public class TeamStanding implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String countryId;
    private String countryName;
    private String leagueId;
    private String leagueName;
    private String teamId;
    private String teamName;
    private String overallStandingPosition;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOverallStandingPosition() {
        return overallStandingPosition;
    }

    public void setOverallStandingPosition(String overallStandingPosition) {
        this.overallStandingPosition = overallStandingPosition;
    }
}
