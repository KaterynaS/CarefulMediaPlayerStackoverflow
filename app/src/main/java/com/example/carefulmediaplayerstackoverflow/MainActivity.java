package com.example.carefulmediaplayerstackoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity {

    //https://stackoverflow.com/questions/11490236/android-comprehensive-failproof-music-service-across-multiple-activities?noredirect=1&lq=1

    Button toSecondButton;
    Button stopServiceButton;
    Intent intent;
    AppState appState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appState = AppState.getInstance();

        updateSoundButton();

        if(appState.isPlaying())
        {
            intent = new Intent(this, MusicService.class);
            startService(intent);
            appState.setIsPlaying(true);
        }



        toSecondButton = findViewById(R.id.to_second_activity_button);
        toSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecond = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(toSecond);
            }
        });


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}
