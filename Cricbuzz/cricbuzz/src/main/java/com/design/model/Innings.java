package com.design.model;

import java.util.ArrayList;
import java.util.List;

import com.design.controller.BattingController;
import com.design.controller.BowlingController;
import com.design.model.matchPattern.MatchType;

public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    BattingController battingController;
    BowlingController bowlingController;
    MatchType matchType;
    List<Over> overs;

    public Innings( Team battingTeam,Team bowlingTeam,MatchType matchType){
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        battingController = new BattingController();
        bowlingController = new BowlingController();
        overs = new ArrayList<>();
    }

    public void startInnings(){
        //choose opener from team 
        //choose nonstriker from team 
        Player opener = this.battingTeam.getNextBatsman();
        Player nonStriker = this.battingTeam.getNextBatsman();
    
        for(int i=1;i<this.matchType.numberOfOvers();i++){
            Player curBowler = this.bowlingTeam.getNextBowler(matchType.numberOfOvers());
            Over newOver = new Over();
        }

        //for each over 
        //pick one bowler 
        //check if he is allowed to bowl

    }
}
