package com.ludwig031.gameoflife;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.Random;

public class SimulationFragment extends Fragment {
    public static SimulationFragment newInstance() {
        return new SimulationFragment();
    }

    public SimulationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void start() {
        flag = true;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    cells = engine.nextGen(cells);

                    Fragment fragment = SimulationFragment.this.getTargetFragment();
                    if (fragment instanceof CellsListener) {
                        ((CellsListener)fragment).update(cells);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException exp) {
                        break;
                    }
                }
            }
        });

        thread.start();
        this.thread = thread;
    }

    public void step() {
        cells = engine.nextGen(cells);

        Fragment fragment = SimulationFragment.this.getTargetFragment();
        if (fragment instanceof CellsListener) {
            ((CellsListener)fragment).update(cells);
        }
    }

    public void stop() {
        flag = false;
        Thread t = this.thread;
        if (t != null) {
            t.interrupt();
            this.thread = null;
        }
    }

    public boolean isStart() {
        return flag;
    }

    public Cells getCells() {
        return this.cells;
    }

    @Override
    public void onPause() {
        super.onDestroy();
        stop();
    }

    public void clear() {
        cells = new Cells(20, 20);
        Fragment fragment = SimulationFragment.this.getTargetFragment();
        if (fragment instanceof CellsListener) {
            ((CellsListener) fragment).update(cells);
        }
    }

    public void random() {
        Random rnd = new Random();

        cells = new Cells(20, 20);
        for (int i = 0; i < 150; i++) {
            int row = rnd.nextInt(20);
            int col = rnd.nextInt(20);
            cells.getCell(row, col).setAlive(true);
        }
        Fragment fragment = SimulationFragment.this.getTargetFragment();
        if (fragment instanceof CellsListener) {
            ((CellsListener) fragment).update(cells);
        }
    }

    private volatile boolean flag = false;
    private Thread thread = null;
    private Engine engine = new BaseEngine();
    private Cells cells = new Cells(20, 20);
}
