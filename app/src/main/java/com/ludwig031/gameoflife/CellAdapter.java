package com.ludwig031.gameoflife;

import java.util.List;

import android.support.annotation.NonNull;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;

public class CellAdapter extends ArrayAdapter<Cell> {
    private Context mContext;
    private List<Cell> cells;

    public CellAdapter(Context c, List<Cell> cells) {
        super(c, R.layout.cell, cells);
        this.cells = cells;
        mContext = c;
    }

    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            textView = (TextView)inflater.inflate(R.layout.cell, null);
        } else {
            textView = (TextView) convertView;
        }

        Cell cell = cells.get(position);

        if (cell.isAlive()) {
            textView.setBackgroundColor(0xFF1FDEF1);
        } else {
            textView.setBackgroundColor(0xFF424242);
        }

        return textView;
    }
}
