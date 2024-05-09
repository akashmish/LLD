package com.design.model;

import java.sql.Date;

import com.design.enums.MatchTypeEnum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Match {
    Integer matchId;
    String matchName;
    Date matchDate;
    Team teamA;
    Team teamB;
    Innings innings1;
    Innings innings2;
    MatchTypeEnum matchType;

    public void startMatch(Team battingTeam,Team bowlingTeam){

        for(int i=0;i<2;i++){
            
        }

    }

}
