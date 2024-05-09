package com.game.model;

import lombok.Getter;

@Getter
public class Move {
    Cell startPosition;
	Cell endPosition;

    public Move(Cell startCell,Cell endCell){
        this.endPosition = endCell;
        this.startPosition = startCell;
    }

    public boolean isValid(){
        if(endPosition.getPiece()!=null && !(startPosition.getPiece().isWhite() == endPosition.getPiece().isWhite()));
    return true;
    }
}
