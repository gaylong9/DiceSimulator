package com.example.flightchessdice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.roll_res_textview);
        textView.setOnClickListener(new View.OnClickListener() {
            Random random = new Random();
            int r, g, b, bias = 50, color_bound = 156;

            @Override
            public void onClick(View v) {
                r = random.nextInt(color_bound) + bias;
                g = random.nextInt(color_bound) + bias;
                b = random.nextInt(color_bound) + bias;
                textView.setText("" + (random.nextInt(6) + 1));
                textView.setTextColor(Color.rgb(r, g, b));
                Log.d(TAG, "onClick: rgb: " + r + "," + g + "," +b);
            }
        });



    }
}
