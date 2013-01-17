package com.chrismcnultygames.jinvaders.main;

import java.util.ArrayList;
import org.newdawn.slick.Music;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.chrismcnultygames.jinvaders.entities.Entity;
import com.chrismcnultygames.jinvaders.entities.Player;
import com.chrismcnultygames.jinvaders.entities.Enemy;
import com.chrismcnultygames.jinvaders.entities.Bullet;

/**
 * 
 * @author Chris McNulty
 *
 * ClassName: JInvadersGame
 * -------------------------------------
 * Description: The purpose of this class is to
 * create all of the assets and display them on screen
 * carry out logic if required
 * 
 */
public class JInvadersGame extends BasicGame
{
	private Player player;
	private ArrayList<Entity> enemyList;
	private Music backgroundSong;
	private Image background;

	public JInvadersGame(String title)
	{
		super(title);
	}
	
	/**
	 * Slick2D Method initialise components
	 */
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		player = new Player();
		enemyList = new ArrayList<Entity>();
		backgroundSong = new Music("Assets/Audio/DST-2ndBallad.ogg");
		background = new Image("Assets/Graphics/background.jpg");
		backgroundSong.loop();
		
		//Creates the enemies
		createEnemies(10,3);
	}
	
	/**
	 * Slick2D Method rendering
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawImage(background, 0, 0);
		player.renderEntity(g);
		
		for(Entity e : enemyList)
		{
			e.renderEntity(g);
		}
	}
	
	/**
	 * Slick2D Method game loop
	 */
	@Override 
	public void update(GameContainer gc, int deltaTime) throws SlickException
	{	
		player.entityLogic(gc,deltaTime);
		  
		for(Entity e : enemyList)
		{
			e.entityLogic(gc, deltaTime);
		}
		
		checkCollisions();  
	}
	
	/**
	 * Creates a grid of enemies
	 */
	private void createEnemies(int row, int col)
	{
		for(int i = 1; i <= row; i++)
		{
			for(int j = 1; j <= col; j++)
			{
				Entity enemy = new Enemy(i*50, j*50);
				enemyList.add(enemy);
			}
		}
		
		System.out.println(enemyList.size());
	}
	
	/**
	 * Check for collisions
	 */
	private void checkCollisions()
	{
		//Get the rectangles from each bullet and enemy from the respective ArralyLists
		for(int i = 0; i < player.bulletList.size(); i++)
		{
			Bullet b = player.bulletList.get(i);
			
			for(int j = 0; j < enemyList.size(); j++)
			{
				Entity e = enemyList.get(j);
				
				//If a bullets rectangle connects with an enemies remove both objects from their lists
				if(b.entityRect.intersects(e.entityRect))
				{
					player.bulletList.remove(i);
					enemyList.remove(j);
					i--;
					j--;
				}
			}
		}
	}
}
