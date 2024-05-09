package com.lld;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        System.out.println( "Hello World!" );
        Runner runner = new Runner();
        runner.takeInput();
        runner.startGame();
    }
}
