package com.ludwig031.gameoflife;

public class Cell {
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAliveNeighbourSize() {
        return aliveNeighbourSize;
    }

    public void setAliveNeighbourSize(int aliveNeighbourSize) {
        this.aliveNeighbourSize = aliveNeighbourSize;
    }

    private boolean alive = false;
    private int aliveNeighbourSize = 0;
}
