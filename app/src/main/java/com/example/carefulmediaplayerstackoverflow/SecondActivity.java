package com.example.carefulmediaplayerstackoverflow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

    Button toMainButton;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        updateSoundButton();

        toMainButton = findViewById(R.id.to_main_activity_button);
        toMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecond = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(toSecond);
            }
        });

        link = findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);

//                Intent intent = new Intent(SecondActivity.this, MusicService.class);
//                stopService(intent);

                CarefulMediaPlayer.getInstance().pause();

            }
        });


    }



    @Override
    protected void onResume() {
        super.onResume();

        AppState appState = AppState.getInstance();

        if(appState.isPlaying())
        {

            CarefulMediaPlayer.getInstance().start();
        }

    }
}
