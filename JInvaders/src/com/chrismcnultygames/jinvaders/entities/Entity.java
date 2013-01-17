package com.chrismcnultygames.jinvaders.entities;

import java.awt.Rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;

public abstract class Entity 
{
	public Image entityImage;
	public int x, y, width, height,speed;
	public Rectangle entityRect;
	
	/**
	 * Method that loads an image for each entity
	 * @param imageName
	 */
	public void loadImage(String imageName)
	{
		try
		{
			entityImage = new Image("Assets/Graphics/"+imageName+".png");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Getters and setters
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setDimenseions(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public Image getImage()
	{
		return entityImage;
	}
	
	/**
	 * Creates a rectangle for the entity
	 */
	public void createRectangle()
	{
		entityRect = new Rectangle(getX(),getY(), getWidth(), getHeight());
	}
	
	/**
	 * Method to carry out logic if input is required
	 * @param gc
	 * @param deltaTime
	 */
	public abstract void entityLogic(GameContainer gc,int deltaTime);
	
	/**
	 * Method to render objects to the screen
	 * @param g
	 */
	public abstract void renderEntity(Graphics g);
	
}
