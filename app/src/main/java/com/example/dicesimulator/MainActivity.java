package com.example.dicesimulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivityTAG";
    private boolean status = true;  // true:num false:image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView num_res = (TextView) findViewById(R.id.roll_res_textview);
        ImageView image_res = (ImageView) findViewById(R.id.dice_res_imageview);
        ImageView switch_button = (ImageView) findViewById(R.id.type_switch_image);
        float scale = 0.5f; // scale switch img
        switch_button.setScaleX(scale);
        switch_button.setScaleY(scale);
        Random random = new Random();

        // num_res, generate a random num when click
        num_res.setOnClickListener(new View.OnClickListener() {
            int r, g, b, bias = 50, color_bound = 156;

            @Override
            public void onClick(View v) {
                r = random.nextInt(color_bound) + bias;
                g = random.nextInt(color_bound) + bias;
                b = random.nextInt(color_bound) + bias;
                num_res.setText("" + (random.nextInt(6) + 1));
                num_res.setTextColor(Color.rgb(r, g, b));
                Log.d(TAG, "onClick: rgb: " + r + "," + g + "," +b);
            }
        });

        // image_res, randomly select a img when click

        image_res.setOnClickListener(new View.OnClickListener() {
            private int[] imgs = {R.drawable.dice_1,
                    R.drawable.dice_2,
                    R.drawable.dice_3,
                    R.drawable.dice_4,
                    R.drawable.dice_5,
                    R.drawable.dice_6};

            @Override
            public void onClick(View v) {
                ((ImageView) v).setImageResource(imgs[random.nextInt(6)]);
                // image_res.setImageResource(imgs[random.nextInt(6)]);
                Log.d(TAG, "onClick: " + v.getId() + " " + image_res.getId());
            }
        });

        // switch_button, switch show type
        switch_button.setOnClickListener(v -> {
            if (status) {
                num_res.setVisibility(View.GONE);
                image_res.setVisibility(View.VISIBLE);
            } else  {
                num_res.setVisibility(View.VISIBLE);
                image_res.setVisibility(View.GONE);
            }
            status = !status;
        });
    }
}
