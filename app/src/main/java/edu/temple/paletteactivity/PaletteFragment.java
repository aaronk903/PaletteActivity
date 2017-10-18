package edu.temple.paletteactivity;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteFragment extends Fragment {

    Sender parent;
    GridView colors;
    ColorAdapter colorAdapter;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context c) {
        super.onAttach(c);
        parent = (Sender)c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        final String[] gridLabels = res.getStringArray(R.array.gridLabels);
        final String[] gridColors = res.getStringArray(R.array.gridColors);

        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        ColorAdapter colorAdapter = new ColorAdapter(v.getContext(), gridLabels, gridColors);

        colors = (GridView) v.findViewById(R.id.color_list);
        colors.setAdapter(colorAdapter);

        colors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                parent.sendColor(gridColors[i]);
            }
        });

        return v;
    }

    public interface Sender {
        public void sendColor(String color);
    }

}
