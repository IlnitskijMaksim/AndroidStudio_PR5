# Практична робота №4
### Тема роботи:
Робота із анімацією та макетами в ОС Android.
### Мета роботи:
Отримати досвід роботи із анімацією та ознайомитись із основними макетами для побудови користувацького інтерфейсу додатків під ОС Android.
# Хід роботи

### Робота з анімацією

https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/801b6572-727d-47dd-9172-ee813a4c5087

### Додавання французьскої локалізації та прапору

В налаштуваннях емулятора мова встановлена французька

![Screenshot_3](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/1b36d426-68ac-4d73-a7b8-f9ce3eed5d15)

![Screenshot_3](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/468ea339-3ba6-403d-8660-ca51efb48e06)

![Screenshot_11](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/b5f14932-d202-4ca1-8cb2-b51c669a63df)

![Screenshot_12](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/8bea8d29-b49c-4308-a52e-5df9ce940ac9)

Якщо змінити в налаштуваннях емулятора мову на англійську, то мова в програмі зміниться. Аналогічно з українською

#### MainActivity
```java
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
```

#### Colors.xml
```java
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="blue_ua">#0057b8</color>
    <color name="yellow_ua">#ffd700</color>
    <color name="black">#000000</color>
    <color name="red">#ff0000</color>
    <color name="blue_fr">#0055A4</color>
    <color name="white">#ffffff</color>
    <color name="red_fr">#ef4135</color>
</resources>
```

#### Strings.xml
```java
<resources>
    <string name="app_name">PR1</string>
    <string name="hello_ua">Привіт!</string>
    <string name="hello_en">Hello!</string>
    <string name="hello_fr">Bonjour!</string>
    <string name="stop_ua">Перестань натискати мене!</string>
    <string name="stop_en">Stop pressing me!</string>
    <string name="stop_fr">Arrête de me presser!</string>
    <string name="emoji">😡😡😡😡😡😡😡</string>
    <string name="button_ua">Натисни мене</string>
    <string name="button_en">Press me</string>
    <string name="button_fr">Presse-moi</string>
</resources>
```

### Використання RelativeLayout

#### Українська мова:

![photo_2024-03-01_01-41-24](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/9b1ee580-04c2-4456-94e5-1a61cd2f4309)

#### Французька мова:

![Screenshot_13](https://github.com/IlnitskijMaksim/AndroidStudio_PR5/assets/112692170/9f93d482-fcb9-458d-a18c-33387f1cd9a6)
