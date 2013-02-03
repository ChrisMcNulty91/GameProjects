package com.chrismcnultygames.ponggdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class CollidableEntity 
{
	public String id;
	public int xSpeed;
	public int ySpeed;
	public Texture texture;
	public Rectangle rectangle;
	public boolean hitLeftWall = false;
	public boolean hitRightWall = false;
	
	public CollidableEntity(String id)
	{
		this.id = id;
		this.rectangle = new Rectangle();
		this.texture = new Texture(Gdx.files.internal("Graphics/"+id+".png"));
	}
	
	
	public abstract void detectCollision(Rectangle rect, Rectangle rightCollidedRect, Rectangle leftCollidedRect);
	public abstract void keepInBounds();
	public abstract void disposeOfSounds();
	
	
}
