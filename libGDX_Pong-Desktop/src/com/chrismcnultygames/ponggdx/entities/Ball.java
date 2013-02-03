package com.chrismcnultygames.ponggdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

public class Ball extends CollidableEntity 
{
	private Sound hitLeftPaddle;
	private Sound hitRightPaddle;
	private Sound hitWalls;
	
	public Ball(int x, int y, int width, int height)
	{
		super("Ball");
		this.xSpeed = -100;
		this.ySpeed = 0;
		this.rectangle.x = x;
		this.rectangle.y = y;
		this.rectangle.width = width;
		this.rectangle.height = height;
		hitRightPaddle = Gdx.audio.newSound(Gdx.files.internal("Audio/RightHit.wav"));
		hitLeftPaddle = Gdx.audio.newSound(Gdx.files.internal("Audio/LeftHit.wav"));
		hitWalls = Gdx.audio.newSound(Gdx.files.internal("Audio/hitWall.wav"));
	}
	
	private void moveBall()
	{
		this.rectangle.x += xSpeed * Gdx.graphics.getDeltaTime();
		this.rectangle.y += ySpeed * Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void keepInBounds()
	{
		this.hitLeftWall = false;
		this.hitRightWall = false;
		
		if(this.rectangle.y  >= 560)
		{
			this.ySpeed = -200;
			hitWalls.play();
		}
		else if(this.rectangle.y <= 0)
		{
			this.ySpeed = 200;
			hitWalls.play();
		}
		
		else if(this.rectangle.x <= 10)
		{
			this.hitLeftWall = true;
			this.xSpeed = 100;
			this.ySpeed = 0;
			
			this.rectangle.x = 400;
			this.rectangle.y = 300;
			
		}
		
		else if(this.rectangle.x >= 780)
		{
			this.hitRightWall = true;
			this.xSpeed = -100;
			this.ySpeed = 0;
			
			this.rectangle.x = 400;
			this.rectangle.y = 300;
			
		}
	}
	
	//TODO improve hit detection logic so ball can move in varrying when depending on where it hits the paddle
	@Override
	public void detectCollision(Rectangle rect, Rectangle rightCollidedRect, Rectangle leftCollidedRect ) 
	{
		moveBall();
		
		if(rect.overlaps(rightCollidedRect))
		{
			this.xSpeed = 150;
			
			if(rect.x >= rightCollidedRect.height/2)
			{
				this.ySpeed = 100;
			}
			
			else if (rect.x <= rightCollidedRect.height/2)
			{
				this.ySpeed = -100;
			}
			
			else
			{
				this.ySpeed = 0;
			}
			
			hitRightPaddle.play();
		}
		
		if(rect.overlaps(leftCollidedRect))
		{
			this.xSpeed = -150;
			
			if(rect.x >= leftCollidedRect.height/2)
			{
				this.ySpeed = -100;
			}
			
			else if (rect.x <= leftCollidedRect.height/2)
			{
				this.ySpeed = -100;
			}
			
			else
			{
				this.ySpeed = 0;
			}
			
			hitLeftPaddle.play();
		}
	}
	
	@Override
	public void disposeOfSounds()
	{
		this.hitLeftPaddle.dispose();
		this.hitRightPaddle.dispose();
		this.hitWalls.dispose();
	}
}
