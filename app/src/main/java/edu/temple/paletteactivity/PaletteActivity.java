package edu.temple.paletteactivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Canvas;
import android.os.Bundle;

public class PaletteActivity extends Activity implements PaletteFragment.Sender {

    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasFragment = new CanvasFragment();
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.paletteFrag, new PaletteFragment()).commit();
        fm.beginTransaction().replace(R.id.canvasFrag, canvasFragment).addToBackStack(null).commit();

    }

    public void sendColor(String hexColor) {
        canvasFragment.showColor(hexColor);
    }
}
