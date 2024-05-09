package com.game.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.game.enums.Status;
import com.game.model.*;
import com.game.model.peices.King;

public class GameController {
    private Board board;
    private ArrayList<Move> gameLog;
    private Status status;
    Queue<Player> q;

    public GameController(Player player1,Player player2){
        this.board = new Board();
        q = new LinkedList<>();
        q.offer(player1);
        q.offer(player2);
        this.status = Status.ACTIVE;
        this.gameLog = new ArrayList<>();
    }

    public void startGame(){
        while(this.status==status.ACTIVE){
            showBoard();
            Player turnPlayer = q.peek();
            q.poll();
            q.offer(turnPlayer);
            Scanner scanner = new Scanner(System.in);
            System.out.println(turnPlayer.getName()+" Enter which piece you want to move x,y :");
            String input = scanner.nextLine();
            String parts[] = input.split(",");
            int fromx = Integer.parseInt(parts[0]);
            int fromy = Integer.parseInt(parts[1]);
            Cell startBlock = board.getCellFromBoard(fromx, fromy);

            System.out.println("Enter where you want to move x,y :");
            input = scanner.nextLine();
            String parts2[] = input.split(",");
            int tox = Integer.parseInt(parts2[0]);
            int toy = Integer.parseInt(parts2[1]);
            Cell endBlock = board.getCellFromBoard(tox, toy);
            
            makeMove(new Move(startBlock,endBlock),turnPlayer);
        }
    }

    private void makeMove(Move newMove, Player turnPlayer) {
        
        if(newMove.isValid()){
            Piece sourcePiece = newMove.getStartPosition().getPiece();
            System.out.println("Piece if +"+sourcePiece);
            if(sourcePiece.canMove(board, newMove.getStartPosition(), newMove.getEndPosition())){
                Piece destinationPiece = newMove.getEndPosition().getPiece();
                if(destinationPiece!=null){
                    //you can possibly hitsomeon
                    if(destinationPiece instanceof King){
                        System.out.println("Player: "+turnPlayer.getName()+" Wins");
                        this.status = Status.ENDED;
                        return;
                    }
                    //if not set destpiece as killes
                    destinationPiece.setKilled(true);
                }
                //adding move to the log
                gameLog.add(newMove);
                newMove.getEndPosition().setPiece(sourcePiece);
                newMove.getStartPosition().setPiece(null);
            }
        }
    }

    private void showBoard() {
        this.board.showBoard();
    }
    
}
