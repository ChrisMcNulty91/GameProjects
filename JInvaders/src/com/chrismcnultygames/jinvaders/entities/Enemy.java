package com.chrismcnultygames.jinvaders.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Enemy extends Entity 
{
	private final String ENTITY_ID = "testEnemy";
	private final int CREATED = 1;
	
	public int currentState;
	
	public Enemy(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.speed = 3;
		this.currentState = CREATED;
		this.setDimenseions(40,35);
		this.loadImage(ENTITY_ID);
		this.createRectangle();
	}
	
	@Override
	public void entityLogic(GameContainer gc, int deltaTime) 
	{
		//TODO add enemy logic
	}

	@Override
	public void renderEntity(Graphics g) 
	{
		g.drawImage(this.getImage(), x, y);
	}
}
