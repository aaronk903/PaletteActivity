package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Aaron on 10/13/2017.
 */


public class ColorAdapter extends BaseAdapter {

    String[] gridLabels;
    String[] gridColors;
    Context c;

    public ColorAdapter(Context c, String[] gridLabels, String[] gridColors){
        this.c = c;
        this.gridLabels = gridLabels;
        this.gridColors = gridColors;
    }

    @Override
    public int getCount() {
        return  gridLabels.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tvItem;
        if (convertView == null) {
            tvItem = new TextView(c);
        } else {
            tvItem = (TextView) convertView;
        }

        tvItem.setText(gridLabels[position]);
        tvItem.setBackgroundColor(Color.parseColor(gridColors[position]));

        return tvItem;
    }


}

