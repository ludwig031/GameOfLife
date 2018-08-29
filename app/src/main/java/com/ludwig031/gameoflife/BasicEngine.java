package com.ludwig031.gameoflife;

public class BasicEngine implements Engine {

    @Override
    public Cells nextGen(Cells cells) {
        final int row = cells.getRow();
        final int col = cells.getCol();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Cell cell = cells.getCell(r, c);

                int aliveNeighbourSize = 0;

                int _r = r - 1;
                _r = _r >= 0 ? _r : row - 1;

                int _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                aliveNeighbourSize += Incrementer(cells, _r, _c);

                _c = c;
                aliveNeighbourSize += Incrementer(cells, _r, _c);

                _c = c + 1;
                _c = _c < col ? _c : 0;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                _r = r;

                _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                _c = c + 1;
                _c = _c < col ? _c : 0;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                _r = r + 1;
                _r = _r < row ? _r : 0;

                _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                _c = c;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                _c = c + 1;
                _c = _c < col ? _c : 0;
                aliveNeighbourSize += Incrementer(cells, _r, _c);


                cell.setAliveNeighbourSize(aliveNeighbourSize);
            }
        }

        Cells result = new Cells(cells.getRow(), cells.getCol());
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                final Cell cell = cells.getCell(r, c);
                final int aliveNeighbourSize = cell.getAliveNeighbourSize();
                final boolean alive = cell.isAlive();

                final boolean shouldAlive;
                if (alive) {
                    if (aliveNeighbourSize < 2) {
                        shouldAlive = false;
                    } else {
                        shouldAlive = (aliveNeighbourSize == 2 || aliveNeighbourSize == 3);
                    }
                } else {
                    shouldAlive = aliveNeighbourSize == 3;
                }

                result.getCell(r, c).setAlive(shouldAlive);
            }
        }

        return result;
    }

    private static int Incrementer(Cells cells,int _r,int _c) {
        if (cells.getCell(_r, _c).isAlive()) {
            return 1;
        } else {
            return 0;
        }
    }
}