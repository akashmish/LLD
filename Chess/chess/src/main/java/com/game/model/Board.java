package com.game.model;

import java.util.ArrayList;
import java.util.List;

import com.game.model.peices.Bishop;
import com.game.model.peices.King;
import com.game.model.peices.Knight;
import com.game.model.peices.Pawn;
import com.game.model.peices.Queen;
import com.game.model.peices.Rook;

import lombok.ToString;

@ToString
public class Board {
    List<List<Cell>> chessBoard;

    public Board() {
        chessBoard = new ArrayList<>();
        for(int i=0;i<8;i++) this.chessBoard.add(new ArrayList<>());
        
        //for white
        for(int i=0;i<8;i++) this.chessBoard.get(1).add(new Cell(1, i, new Pawn(true)));
        this.chessBoard.get(0).add(new Cell(0,0,new Rook(true)));
        this.chessBoard.get(0).add(new Cell(0,1,new Knight(true)));
        this.chessBoard.get(0).add(new Cell(0,2,new Bishop(true)));
        this.chessBoard.get(0).add(new Cell(0,3,new Queen(true)));
        this.chessBoard.get(0).add(new Cell(0,4,new King(true)));
        this.chessBoard.get(0).add(new Cell(0,5,new Knight(true)));
        this.chessBoard.get(0).add(new Cell(0,6,new Bishop(true)));
        this.chessBoard.get(0).add(new Cell(0,7,new Rook(true)));
        
        //for black 
        for(int i=0;i<8;i++) this.chessBoard.get(6).add(new Cell(6, i, new Pawn(false)));
        this.chessBoard.get(7).add(new Cell(7,0,new Rook(false)));
        this.chessBoard.get(7).add(new Cell(7,1,new Knight(false)));
        this.chessBoard.get(7).add(new Cell(7,2,new Bishop(false)));
        this.chessBoard.get(7).add(new Cell(7,3,new Queen(false)));
        this.chessBoard.get(7).add(new Cell(7,4,new King(false)));
        this.chessBoard.get(7).add(new Cell(7,5,new Knight(false)));
        this.chessBoard.get(7).add(new Cell(7,6,new Bishop(false)));
        this.chessBoard.get(7).add(new Cell(7,7,new Rook(false)));        

        //set all others as null
        for(int i=2;i<6;i++){
            for( int j=0; j<8; j++){
                chessBoard.get(i).add(new Cell(i,j));
            }
        }
    }

    public void resetBoard(){
        //reset board
    }

    public void updateBoard(Move move){

    }

    public Cell getCellFromBoard(int x,int y){
        return this.chessBoard.get(x).get(y);
    }

    public void showBoard() {
        for(var rows : chessBoard){
            for(var pieces : rows){
                String value = ".";
                if(pieces.getPiece() instanceof King) value = "K";
                if(pieces.getPiece() instanceof Queen) value = "Q";
                if(pieces.getPiece() instanceof Pawn) value = "P";
                if(pieces.getPiece() instanceof Bishop) value = "B";
                if(pieces.getPiece() instanceof Knight) value = "N";
                if(pieces.getPiece() instanceof Rook) value = "R";
                System.out.print(value+" | ");
            }
            System.out.println("");
        }
    }
}
