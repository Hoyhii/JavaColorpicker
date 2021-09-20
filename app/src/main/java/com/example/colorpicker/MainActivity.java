package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int redSeek;
    private int greenSeek;
    private int blueSeek;
    SeekBar redBar, greenBar, blueBar;
    LinearLayout myPicker;
    TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPicker = findViewById(R.id.myPicker);
        redBar = findViewById(R.id.bar_red);
        greenBar = findViewById(R.id.bar_green);
        blueBar = findViewById(R.id.bar_blue);
        text_view = findViewById(R.id.text_view);

        ColorAndTextUpdate();

        redBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueBar.setOnSeekBarChangeListener(seekBarChangeListener);


    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            ColorAndTextUpdate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void ColorAndTextUpdate() {

        redSeek = redBar.getProgress();
        greenSeek = greenBar.getProgress();
        blueSeek = blueBar.getProgress();
        String comma = ",";

        if (redSeek < 150 && greenSeek < 150 && blueSeek < 150) {
            text_view.setTextColor(Color.WHITE);
        } else {
            text_view.setTextColor(Color.BLACK);
        }

        text_view.setBackgroundColor(0xff000000 + redSeek * 0x10000 + greenSeek * 0x100 + blueSeek);
        text_view.setText(redSeek + comma + greenSeek + comma + blueSeek);


    }
}
