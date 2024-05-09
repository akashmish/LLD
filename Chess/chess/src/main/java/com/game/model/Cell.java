package com.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {
    private int row;
    private int col;
    private Piece piece;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
