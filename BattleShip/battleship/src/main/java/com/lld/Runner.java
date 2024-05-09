package com.lld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.lld.model.Player;
import com.lld.model.Ship;

import lombok.var;

public class Runner {
    private final List<Ship> ships1,ships2;
    private final Deque<Player> q;
    private int gridsize;
    private int shipSize;

    public Runner(){
        ships1 = new ArrayList<>();
        ships2 = new ArrayList<>();
        q = new LinkedList<>();
        q.offer(Player.builder().playerName("foo").id(1).build());
        q.offer(Player.builder().playerName("bar").id(2).build());
    }

    void startGame(){
        boolean noWinner = true;
        Player winnerPlayer=null;
        while(noWinner){
            Player playerTurn = q.peek();
            q.poll();
            q.offer(playerTurn);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hey "+playerTurn.getPlayerName()+" its your turn enter x :");
            int x = scanner.nextInt();
            System.out.println("Hey "+playerTurn.getPlayerName()+" its your turn enter y :");
            int y = scanner.nextInt();

            if(isCordinateValid(x,y)){
                if(isHit(x,y,playerTurn)){
                    noWinner = false;
                    winnerPlayer = playerTurn;
                }
            }else{
                System.out.println("Looks like you've entered invalid cordinate, Please retry");
                Player playerReturn = q.removeLast();
                q.addFirst(playerReturn);
                continue;
            }
        }

        System.out.println("Winner is "+winnerPlayer.getPlayerName());
    }

    private boolean isCordinateValid(int x, int y) {
        if(x>=0&&y>=0&&x<gridsize&&y<gridsize) return true;
        return false;
    }

    private boolean isHit(int x, int y, Player playerTurn) {
        //if player 1 hits check ships2
        int shipdest=-1;
        if(playerTurn.getId()==1){
            for(int i=0;i<ships2.size();i++){
                var ship = ships2.get(i);
                if(x>=ship.getMinr()&&x<=ship.getMaxr() && y>=ship.getMinc()&&y<=ship.getMaxc()){
                    System.out.println("Ship destroyed by Player: "+playerTurn.getPlayerName());
                    shipdest = i;
                    if(ships2.size()==1) return true;
                }
            }
            if(shipdest!=-1){
                ships2.remove(shipdest);
            }else{
                System.out.println("It was a miss");
            }
        }else{
            for(int i=0;i<ships1.size();i++){
                var ship = ships1.get(i);
                if(x>=ship.getMinr()&&x<=ship.getMaxr() && y>=ship.getMinc()&&y<=ship.getMaxc()){
                    System.out.println("Ship destroyed by Player: "+playerTurn.getPlayerName());
                    shipdest=i;
                    if(ships1.size()==1) return true;
                }
            }
            if(shipdest!=-1){
                ships1.remove(shipdest);
            }else{
                System.out.println("It was a miss");
            }  
        }
        return false;
    }

    public void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter battleground size (N) :");
        gridsize = scanner.nextInt();   

        System.out.println("Enter ship's size");
        shipSize = scanner.nextInt();

        System.out.println("Enter number of ships");
        int totShips = scanner.nextInt();
        int counter = totShips;
        int n=1;

        while(counter-->0){
            System.out.println("Enter ship number: "+n+" cordinates");
            System.out.println("Player 1 enter x");
            int x = scanner.nextInt();
            System.out.println("Player 1 enter y");
            int y = scanner.nextInt();

            if(isValid(x,y,1)){
                Ship s = new Ship(x,y,x+shipSize,y+shipSize);
                ships1.add(s);
            }else{
                System.out.println("Oops you went into other territory please enter again!");
                System.out.println("Please enter value lesser than "+gridsize/2);
                counter++;
                continue;
            }
            n++;
        }

        System.out.println("--------");

        counter = totShips;
        n=1;
        while(counter-->0){
            System.out.println("Enter ship number: "+n+" cordinates");
            System.out.println("Player 2 enter x");
            int x = scanner.nextInt();
            System.out.println("Player 2 enter y");
            int y = scanner.nextInt();
            if(isValid(x,y,2)){
                Ship s = new Ship(x,y,x+shipSize,y+shipSize);
                ships2.add(s);
            }else{
                System.out.println("Oops you went into other territory please enter again!");
                System.out.println("Please enter value greater than "+gridsize/2);
                counter++;
                continue;
            }
            n++;
        }
    }

    

    private boolean isValid(int x, int y,int player) {
        if(player==1){
            //left side
            if(x+shipSize>gridsize/2 || x<0) return false;
            return true;
        }else{
            //right side
            if(x<gridsize/2 || x+shipSize>gridsize || x<0 ) return false;
        }
        return true;
    }
}
