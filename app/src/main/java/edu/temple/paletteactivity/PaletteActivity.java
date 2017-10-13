package edu.temple.paletteactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

public class PaletteActivity extends Activity {

    class MyAdapter extends BaseAdapter {
        private Context context;
        Resources res = getResources();
        String[] gridLabels = res.getStringArray(R.array.gridLabels);
        String[] gridColors = res.getStringArray(R.array.gridColors);

        public MyAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return gridColors.length;
        }

        public String getItem(int position) {
            return gridLabels[position];
        }

        public String getColor(int position) {
            return gridColors[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView tv;

            if (convertView == null) {
                tv = new TextView(context);
                String text = (String) getItem(position);
                tv.setText(text);
                if(text.equals("Black") || text.equals("Negro"))
                    tv.setTextColor(Color.WHITE);
                String color = getColor(position);
                tv.setBackgroundColor(Color.parseColor(color));
            } else {
                tv = (TextView) convertView;
            }

            return tv;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        final MyAdapter myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent canvas = new Intent(PaletteActivity.this, CanvasActivity.class);
                canvas.putExtra("COLOR", myAdapter.getColor(i));
                startActivity(canvas);
            }
        });

    }
}
