package com.game;

import com.game.controller.GameController;
import com.game.enums.Color;
import com.game.model.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Player p1 = new Player("Player1", 1, Color.WHITE);
        Player p2 = new Player("Player2", 2, Color.BLACK);
        GameController gc = new GameController(p1, p2);
        gc.startGame();
    }
}
