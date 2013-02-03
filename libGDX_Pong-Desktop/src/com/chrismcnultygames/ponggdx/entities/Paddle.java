package com.chrismcnultygames.ponggdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Paddle extends Entity
{
	public Paddle(int x , int y, int width, int height)
	{
		super("Paddle", 200);
		this.score = 0;
		this.rectangle.x = x;
		this.rectangle.y = y;
		this.rectangle.width = width;
		this.rectangle.height = height;
	}

	@Override
	public void handleInput() 
	{
		/* Code for PC */
		if(Gdx.input.isKeyPressed(Input.Keys.W))
		{
			this.rectangle.y += this.speed * Gdx.graphics.getDeltaTime(); 
		}
		
		else if(Gdx.input.isKeyPressed(Input.Keys.S))
		{
			this.rectangle.y -= this.speed * Gdx.graphics.getDeltaTime(); 
		}
		
		/*Code for Android */
		if(Gdx.input.isTouched() && Gdx.input.getY() > 300)
		{
			this.rectangle.y -= this.speed * Gdx.graphics.getDeltaTime(); 
		}
		
		else if(Gdx.input.isTouched() && Gdx.input.getY() < 300)
		{
			this.rectangle.y += this.speed * Gdx.graphics.getDeltaTime(); 
		}
	}
	
	//TODO add ai for the secondPaddle
	@Override
	public void paddleAi(CollidableEntity ball)
	{
		this.rectangle.y = ball.rectangle.y;
	}
	
	@Override
	public void keepInBounds() 
	{
		if(this.rectangle.y <= 0 )
		{
			this.rectangle.y = 0;
		}
		
		else if(this.rectangle.y >= 560 )
		{
			this.rectangle.y = 560;
		}
	}
}
