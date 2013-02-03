package com.chrismcnultygames.ponggdx;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.chrismcnultygames.ponggdx.Pong;

import android.os.Bundle;

public class PongAndroidStarter extends AndroidApplication {
    /** Called when the activity is first created. */

	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Pong(),true);
    }
}