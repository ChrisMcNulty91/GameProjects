package com.chrismcnultygames.ponggdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.chrismcnultygames.ponggdx.Pong;

public class GameOverScreen extends GameScreens implements Screen 
{
	private Texture gameOverImage;
	private Pong pong;
	private Sound startSound;
	
	public GameOverScreen(Pong pong) 
	{
		super("Game Over");
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
		batch.draw(gameOverImage,0,0);
		batch.end();
	}
	
	@Override
	public void show() 
	{
		startSound = Gdx.audio.newSound(Gdx.files.internal("Audio/StartGameSound.wav"));
		gameOverImage = new Texture(Gdx.files.internal("Graphics/GameOver.png"));
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() 
	{
		gameOverImage.dispose();
		startSound.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
}
