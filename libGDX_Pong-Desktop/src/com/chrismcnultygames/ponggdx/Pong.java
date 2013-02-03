package com.chrismcnultygames.ponggdx;

import com.badlogic.gdx.Game;
import com.chrismcnultygames.ponggdx.screens.MainMenuScreen;

public class Pong extends Game
{
	
	//TODO improve movement of ball
	//TODO add ai for the right side Paddle
	//TODO implement score system and win/lose conditions
	//TODO create seperate screens for MainMenu, Gameplay, WinScreen and PauseScreen
	
	@Override
	public void create() 
	{
		this.setScreen(new MainMenuScreen(this));
		
	}
		
	@Override
	public void dispose()
	{
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
}
