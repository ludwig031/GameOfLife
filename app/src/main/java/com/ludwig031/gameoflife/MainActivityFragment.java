package com.ludwig031.gameoflife;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivityFragment extends Fragment implements CellsListener {

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FragmentManager fm = getFragmentManager();

        simulationFragment = (SimulationFragment)fm.findFragmentByTag(SIMULATION_FRAGMENT);

        if (simulationFragment == null) {
            simulationFragment = SimulationFragment.newInstance();
            simulationFragment.setTargetFragment(this, 0);
            fm.beginTransaction().add(simulationFragment, SIMULATION_FRAGMENT).commitAllowingStateLoss();
            simulationFragment.random();
        } else {
            simulationFragment.setTargetFragment(this, 0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.gridView = (GridView)view.findViewById(R.id.grid_view);

        this.cellAdapter = new CellAdapter(this.getActivity(), simulationFragment.getCells().getList());
        this.cellAdapter.setNotifyOnChange(false);
        gridView.setAdapter(cellAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                if (simulationFragment.isStart()) {
                    Toast.makeText(MainActivityFragment.this.getContext(), "Prvo zaustavi proces", Toast.LENGTH_SHORT).show();
                } else {
                    final CellAdapter cellAdapter = (CellAdapter) gridView.getAdapter();
                    Cell cell = cellAdapter.getItem(position);
                    cell.setAlive(!cell.isAlive());
                    cellAdapter.notifyDataSetChanged();
                }
            }
        });

        final Button startButton = (Button) view.findViewById(R.id.start_button);
        startButton.setText(simulationFragment.isStart() ? "STOP" : "START");
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simulationFragment.isStart()) {
                    startButton.setText("Start");
                    simulationFragment.stop();
                } else {
                    startButton.setText("Stop");
                    simulationFragment.start();
                }
            }
        });

        final Button stepButton = (Button) view.findViewById(R.id.step_button);
        stepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simulationFragment.isStart()) {
                    Toast.makeText(MainActivityFragment.this.getContext(), "Prvo zaustavi proces", Toast.LENGTH_SHORT).show();
                } else {
                    simulationFragment.step();
                }
            }
        });

        final Button randomButton = (Button) view.findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simulationFragment.isStart()) {
                    Toast.makeText(MainActivityFragment.this.getContext(), "Prvo zaustavi proces", Toast.LENGTH_SHORT).show();
                } else {
                    simulationFragment.random();
                }
            }
        });

        final Button clearButton = (Button) view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simulationFragment.isStart()) {
                    Toast.makeText(MainActivityFragment.this.getContext(), "Prvo zaustavi proces", Toast.LENGTH_SHORT).show();
                } else {
                    simulationFragment.clear();
                }
            }
        });

        return view;
    }

        @Override
    public void update(final Cells cells) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CellAdapter cellAdapter = MainActivityFragment.this.cellAdapter;

                    if (cellAdapter == null) {
                        return;
                    }
                    cellAdapter.clear();
                    cellAdapter.addAll(cells.getList());
                    cellAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    private GridView gridView;
    private CellAdapter cellAdapter;
    private static final String SIMULATION_FRAGMENT = "SIMULATION_FRAGMENT";
    private SimulationFragment simulationFragment;
}
