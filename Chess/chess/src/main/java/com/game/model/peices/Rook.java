package com.game.model.peices;

import java.util.List;

import com.game.model.Board;
import com.game.model.Cell;
import com.game.model.Piece;
import com.game.model.Position;

public class Rook extends Piece{

    public Rook(boolean flag) {
        super(flag);
    }

    @Override
    public boolean canMove(Board board, Cell fromPosition, Cell toPosition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }
    
}
