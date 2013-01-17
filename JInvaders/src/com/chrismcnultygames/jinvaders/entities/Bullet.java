package com.chrismcnultygames.jinvaders.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public class Bullet extends Entity
{
	private final String ENTITY_ID = "bullet";
	
	public Bullet(int x , int y)
	{
		this.x = x;
		this.y = y;
		this.loadImage(ENTITY_ID);
		this.setDimenseions(15, 15);
		this.createRectangle();
	}
	
	/**
	 * Moves the bullet up the Y-Axis
	 */
	public void moveBullet()
	{
		this.setSpeed(3);
		this.y -= speed;
		this.entityRect.y -= speed;
	}
	
	@Override
	public void entityLogic(GameContainer gc, int deltaTime){}
	
	@Override
	public void renderEntity(Graphics g) 
	{
		g.drawImage(this.getImage(), this.getX(), this.getY());
	}
}
