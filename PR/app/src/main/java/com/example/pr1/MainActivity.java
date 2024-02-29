package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button simpleButton;
    private TextView simpleTextView;
    private int i = 0;

    private boolean isUkrainianLocale() {
        Locale currentLocale = getResources().getConfiguration().locale;
        String currentLanguage = currentLocale.getLanguage();
        return currentLanguage.equals("uk");
    }
    private boolean isFrenchLocale() {
        Locale currentLocale = getResources().getConfiguration().locale;
        String currentLanguage = currentLocale.getLanguage();
        return currentLanguage.equals("fr");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleButton = findViewById(R.id.simpleButton);
        simpleTextView = findViewById(R.id.simpleTextView);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        int blue = ContextCompat.getColor(this, R.color.blue_ua);
        int yellow = ContextCompat.getColor(this, R.color.yellow_ua);
        int black = ContextCompat.getColor(this, R.color.black);
        int red = ContextCompat.getColor(this, R.color.red );
        int blue_fr = ContextCompat.getColor(this, R.color.blue_fr);
        int white = ContextCompat.getColor(this, R.color.white);
        int red_fr = ContextCompat.getColor(this, R.color.red_fr);


        GradientDrawable gradientDrawableUA = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{blue, yellow});
        GradientDrawable gradientDrawableAnother = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{black, red});
        GradientDrawable gradientDrawableFrance = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{blue_fr, white, white, red_fr});

        if (isUkrainianLocale()){
            linearLayout.setBackground(gradientDrawableUA);
            simpleButton.setText(R.string.button_ua);
            simpleTextView.setTextColor(Color.WHITE);
        }

        else if (isFrenchLocale()) {
            linearLayout.setBackground(gradientDrawableFrance);
            simpleButton.setText(R.string.button_fr);
            simpleTextView.setTextColor(Color.BLACK);

        } else {
            linearLayout.setBackground(gradientDrawableAnother);
            simpleButton.setText(R.string.button_en);
            simpleTextView.setTextColor(Color.WHITE);
        }

        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUkrainianLocale()) {
                    if (i == 0) {
                        simpleTextView.setText(R.string.hello_ua);
                        i++;
                    } else if (i == 1) {
                        simpleTextView.setText(R.string.stop_ua);
                        i++;
                    } else {
                        simpleTextView.setText(R.string.emoji);
                        i = 0;
                        simpleButton.setEnabled(false);
                    }
                } else if (isFrenchLocale()) {
                    if (i == 0) {
                        simpleTextView.setText(R.string.hello_fr);
                        i++;
                    } else if (i == 1) {
                        simpleTextView.setText(R.string.stop_fr);
                        i++;
                    } else {
                        simpleTextView.setText(R.string.emoji);
                        i = 0;
                        simpleButton.setEnabled(false);
                    }
                } else {
                    linearLayout.setBackground(gradientDrawableAnother);
                    if (i == 0) {
                        simpleTextView.setText(R.string.hello_en);
                        i++;
                    } else if (i == 1) {
                        simpleTextView.setText(R.string.stop_en);
                        i++;
                    } else {
                        simpleTextView.setText(R.string.emoji);
                        i = 0;
                        simpleButton.setEnabled(false);
                    }
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        showScreenMessage("App started", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showScreenMessage("App restarted", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        showScreenMessage("App paused", Toast.LENGTH_SHORT);
    }

    private void showScreenMessage(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }
}
