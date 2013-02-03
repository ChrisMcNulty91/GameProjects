package com.chrismcnultygames.ponggdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.chrismcnultygames.ponggdx.Pong;

public class MainMenuScreen  extends GameScreens implements Screen
{
	private Texture MainMenuLogo;
	private Pong pong;
	private Sound startSound;
	
	public MainMenuScreen(Pong pong)
	{
		super("Title");
		this.pong = pong;
	}
	
	@Override
	public void render(float delta) 
	{
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched())
		{
			startSound.play();
			pong.setScreen(new MainGameScreen(pong));
			System.out.println("Being Touched");
		}
		
		Gdx.gl.glClearColor(0, 0, 0.0f,0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(this.MainMenuLogo,0,0);
		batch.end();
	}
	
	@Override
	public void show()
	{
		startSound = Gdx.audio.newSound(Gdx.files.internal("Audio/StartGameSound.wav"));
		MainMenuLogo = new Texture(Gdx.files.internal("Graphics/"+ this.id +".png"));
	}
	
	@Override
	public void dispose()
	{
		MainMenuLogo.dispose();
		startSound.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {}
	
	@Override
	public void hide(){}

	@Override
	public void pause(){}

	@Override
	public void resume(){}
}
