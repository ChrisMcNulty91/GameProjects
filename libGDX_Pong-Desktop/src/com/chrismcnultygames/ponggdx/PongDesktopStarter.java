package com.chrismcnultygames.ponggdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class PongDesktopStarter 
{
	public static void main(String[] args) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Desktop Test";
		config.useGL20 = true;
		config.width = 800;
		config.height = 600;
		
		new LwjglApplication(new Pong(),config);
	}
}
