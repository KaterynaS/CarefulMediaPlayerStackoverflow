package com.example.carefulmediaplayerstackoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    Button toMainButton;

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


    }


}
