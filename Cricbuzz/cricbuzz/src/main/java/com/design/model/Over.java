package com.design.model;

import java.util.ArrayList;
import java.util.List;

public class Over {
    int overnumber;
    List<Ball> balls;
    Player bowledBy;

    public Over(int overnumber,Player bolwedBy){
        this.overnumber = overnumber;
        this.bowledBy = bolwedBy;
        balls = new ArrayList<>();
    }

    public boolean startOver(){

        int ballCount = 1;
        while(ballCount<=6){
            Ball ball = new Ball(ballCount);
            ball.
        }



        return true;
    }

}
