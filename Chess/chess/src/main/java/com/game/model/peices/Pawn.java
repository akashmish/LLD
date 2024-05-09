package com.game.model.peices;

import java.util.List;

import com.game.model.Board;
import com.game.model.Cell;
import com.game.model.Piece;


public class Pawn extends Piece{

    public Pawn(boolean flag) {
        super(flag);
    }

    @Override
    public boolean canMove(Board board, Cell fromPosition, Cell toPosition) {
       return  true;
    }


    // @Override
    // public boolean move(List<List<Cell>> gameboard,Position fromPosition, Position toPosition) {
    //     Cell toCell = gameboard.get(toPosition.getRow()).get(toPosition.getColumn());
    //     Piece toPiece = toCell.getPiece();
    //     Cell fromCell = gameboard.get(fromPosition.getRow()).get(fromPosition.getColumn());
    //     Piece fromPiece = fromCell.getPiece();

    //     //check for overflow
    //     if(fromPiece.getColor().equals(toPiece.getColor()) ){
    //         System.out.println("You can't attack same color");
    //         return false;
    //     }

    //     if(isFrontBlocked()){
    //         System.out.println("Front is blocked or you reached end");
    //         return false;
    //     }

    //     int row_disp = Math.abs(toPosition.getRow()-fromPosition.getRow());
    //     int col_disp = Math.abs(toPosition.getColumn()-fromPosition.getColumn());
    //     if(row_disp==1.0 && col_disp==0){
    //         //moving ahead let it move 
    //         return true;
    //     }else if(row_disp==1.0 && col_disp==1){
    //         //check if toPosition has a opponet
    //         if(isOpponent(fromPiece,toPiece)){
    //             return true;
    //         }
    //     }else{
    //         System.out.println("Invalid move fro pawn");
    //     }
    //     return false;
    // }

    // private boolean isFrontBlocked() {
    //    //check if front is blocked
    //    return false;
    // }

    // private boolean isOpponent(Piece fromPiece, Piece toPiece) {
    //     return !(fromPiece.getColor().equals(toPiece.getColor()));
    // }

    // @Override
    // public boolean validate(Position fromPosition, Position toPosition) {
    //     return true;
    // }

    // @Override
    // public List<Position> getPossibleMoves(Position fromPosition) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getPossibleMoves'");
    // }
    
}
