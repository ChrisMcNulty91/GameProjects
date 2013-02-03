package com.chrismcnultygames.ponggdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity 
{
	public String id;
	public int speed;
	public int score;
	public Texture texture;
	public Rectangle rectangle;
	
	public Entity(String id,int speed)
	{
		this.id = id;
		this.speed = speed;
		this.rectangle = new Rectangle();
		this.texture = new Texture(Gdx.files.internal("Graphics/"+id+".png"));
	}
	
	public abstract void handleInput();
	public abstract void keepInBounds();
	public abstract void paddleAi(CollidableEntity ball);
}
