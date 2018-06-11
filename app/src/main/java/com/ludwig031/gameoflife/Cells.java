package com.ludwig031.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cells {
    public Cells(int row, int col) {
        this.row = row;
        this.col = col;

        for (int i = 0; i < this.row * this.col; i++) {
            cells.add(new Cell());
        }
    }

    public Cell getCell(int row, int col) {
        int index = (row * this.col) + col;
        return cells.get(index);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public List<Cell> getList() {
        return cells;
    }

    private final List<Cell> cells = new ArrayList<>();
    private final int row;
    private final int col;
}
