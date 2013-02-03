package com.chrismcnultygames.ponggdx.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameScreens 
{
	protected SpriteBatch batch;
	protected String id;
	
	public GameScreens(String id)
	{
		this.id = id;
		batch = new SpriteBatch();
	}
}
