package com.chrismcnultygames.jinvaders.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class JinvaderRunner
{
	
	public static void main(String[] args) 
	{
		try
		{
			AppGameContainer jinvaders = new AppGameContainer(new JInvadersGame("EmeraldZoneGames - JInvaders"));
			jinvaders.setDisplayMode(800, 600, false);
			jinvaders.setVSync(true);
			jinvaders.setShowFPS(false);
			jinvaders.start();
		}
		catch(SlickException se)
		{
			se.printStackTrace();
		}
		
	}

}
