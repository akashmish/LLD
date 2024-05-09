package com.game;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.game.controller.GameController;
import com.game.enums.Color;
import com.game.model.Board;
import com.game.model.Player;

/**
 * Unit test for simple App.
 */
public class ChessTest 
{


    void setup(){
       


    }


    @Test
    public void playChess()
    {
        Player p1 = new Player("Player1", 1, Color.WHITE);
        Player p2 = new Player("Player2", 2, Color.BLACK);
        GameController gc = new GameController(p1, p2);
        gc.startGame();
        // System.out.println(board.toString());
    }
}
