package edu.temple.paletteactivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        View view = getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("COLOR")));


    }
}
