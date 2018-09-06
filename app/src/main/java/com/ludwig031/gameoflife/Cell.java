package com.ludwig031.gameoflife;

public class Cell {
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAliveNeighbourCount() {
        return aliveNeighbourCount;
    }

    public void setAliveNeighbourCount(int aliveNeighbourCount) {
        this.aliveNeighbourCount = aliveNeighbourCount;
    }

    private boolean alive = false;
    private int aliveNeighbourCount = 0;
}
