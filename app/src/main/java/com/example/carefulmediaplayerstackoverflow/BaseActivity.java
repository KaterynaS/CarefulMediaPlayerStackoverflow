package com.example.carefulmediaplayerstackoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class BaseActivity extends AppCompatActivity {

    private boolean isHome = true;
    AppState appState;
    ImageButton soundImageButton;


    public void updateSoundButton()
    {
        appState = AppState.getInstance();
        soundImageButton = findViewById(R.id.sound_imagebutton);
        if(appState.isPlaying())
        {
            soundImageButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_up));
        }
        else
        {
            soundImageButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_off));
        }
    }

    public void turnSound(View v)
    {
        appState = AppState.getInstance();
        soundImageButton = findViewById(R.id.sound_imagebutton);

        if(appState.isPlaying())
        {
            appState.setIsPlaying(false);
            MusicService.onPause();
            soundImageButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_off));
        }
        else
        {
            appState.setIsPlaying(true);
            MusicService.onResume();
            soundImageButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_up));
        }
    }


    @Override
    protected void onResume() {
        System.gc();
        super.onResume();

        appState = AppState.getInstance();
        if(appState.isPlaying())
        {
            MusicService.onResume();
        }

        isHome = true;
    }

    @Override
    protected void onPause() {
        if (((TelephonyManager)getSystemService(TELEPHONY_SERVICE)).getCallState()==TelephonyManager.CALL_STATE_RINGING
                || !((PowerManager)getSystemService(POWER_SERVICE)).isScreenOn()) {
            MusicService.onPause();
        }
        super.onPause();
        System.gc();
    }

    @Override
    public boolean onKeyDown (final int keyCode, final KeyEvent ke) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                isHome = false;
            default:
                return super.onKeyDown(keyCode, ke);
        }
    }

    @Override
    public void startActivity(final Intent i) {
        isHome = false;
        super.startActivity(i);
    }

    @Override
    protected void onUserLeaveHint() {
        if (isHome) {
            MusicService.onPause();
        }
        super.onUserLeaveHint();
    }
}
