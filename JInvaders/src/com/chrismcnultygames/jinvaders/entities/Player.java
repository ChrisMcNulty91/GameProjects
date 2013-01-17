package com.chrismcnultygames.jinvaders.entities;

import java.util.ArrayList;
import org.newdawn.slick.Input;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;

/**
 * 
 * @author Chris McNulty
 *
 * ClassName: Player
 * -------------------------------------
 * Description: The purpose of this class is to
 * Define all of the operations that are carried
 * out by the Player Object
 * 
 */
public class Player extends Entity 
{
	public ArrayList<Bullet> bulletList;
	
	private boolean isFiring;
	private final String ENTITY_ID = "ship";
	
	
	public Player()
	{	
		bulletList = new ArrayList<Bullet>();
		this.loadImage(ENTITY_ID);
		this.setPosition(350,450);
		this.setDimenseions(100, 100);
		this.setSpeed(5);
		this.createRectangle();
	}
	
	@Override
	public void entityLogic(GameContainer gc, int deltaTime) 
	{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_A))
		{
			this.x -= speed;
			this.entityRect.x -= speed;
		}
		
		if(input.isKeyDown(Input.KEY_D))
		{
			this.x += speed;
			this.entityRect.x -= speed;
		}
		
		if(input.isKeyDown(Input.KEY_W))
		{
			this.y -= speed;
			this.entityRect.y -= speed;
		}
		
		if(input.isKeyDown(Input.KEY_S))
		{
			this.y += speed;
			this.entityRect.y += speed;
		}
		
		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			isFiring = true;
			addToList();
		}
		
		checkBounds();
		fireBullet();
		destroyBullets();
	}
	
	@Override
	public void renderEntity(Graphics g) 
	{
		g.drawImage(this.getImage(), this.getX(), this.getY());
		
		if(isFiring)
		{
			for(Bullet b : bulletList)
			{
				b.renderEntity(g);
			}
		}
	}
	
	/**
	 * Populates the arrayList with instances of the bullet object
	 */
	private void addToList()
	{
		Bullet bullet = new Bullet(this.x+40,this.y);
		bulletList.add(bullet);
	}
	
	/**
	 * Moves the bullet when player is firing
	 */
	private void fireBullet()
	{
		if(isFiring)
		{
			for(Bullet b:bulletList)
			{
				b.moveBullet();
			}
		}
	}
	
	/**
	 * Destroys intances of the bullet once the bullet goes out of it's bounds
	 */
	private void destroyBullets()
	{
		for(int i = 0; i < bulletList.size(); i++)
		{
			Bullet bullet = bulletList.get(i);
			
			if(bullet.y <= 0)
			{
				bulletList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Method to check if the player is on the screen at all times
	 */
	private void checkBounds()
	{
		if( this.x > 720)
		{
			this.x = 720;
		}
		
		else if( this.x < 0)
		{
			this.x = 0;
		}
		
		else if( this.y > 450)
		{
			this.y = 450;
		}
	}
}