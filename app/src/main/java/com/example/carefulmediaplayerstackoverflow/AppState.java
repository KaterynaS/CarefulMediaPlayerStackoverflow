package com.example.carefulmediaplayerstackoverflow;

class AppState {

    private  boolean isPlaying = true;

    private static final AppState ourInstance = new AppState();

    static AppState getInstance() {
        return ourInstance;
    }

    private AppState() {
    }

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
