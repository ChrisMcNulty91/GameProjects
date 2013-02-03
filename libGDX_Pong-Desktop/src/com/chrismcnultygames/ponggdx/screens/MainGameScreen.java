package com.chrismcnultygames.ponggdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.chrismcnultygames.ponggdx.Pong;
import com.chrismcnultygames.ponggdx.entities.Ball;
import com.chrismcnultygames.ponggdx.entities.CollidableEntity;
import com.chrismcnultygames.ponggdx.entities.Entity;
import com.chrismcnultygames.ponggdx.entities.Paddle;

public class MainGameScreen extends GameScreens  implements Screen
{
	private Pong pong;
	private FPSLogger fps;
	private Entity leftPaddle;
	private Entity rightPaddle;
	private CollidableEntity ball;
	private OrthographicCamera camera;
	private BitmapFont font;
	private Texture net;
	
	public MainGameScreen(Pong pong)
	{
		super("Pong-GDX");
		this.pong = pong;
	}

	@Override
	public void render(float delta)
	{

		fps.log();
		Gdx.gl.glClearColor(0, 0, 0.0f,0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(net, 370,0);
		font.setColor(Color.WHITE);
		font.draw(batch, " "+leftPaddle.score, 150, 550);
		font.draw(batch, " "+rightPaddle.score, 550, 550);
		batch.draw(leftPaddle.texture,leftPaddle.rectangle.x,leftPaddle.rectangle.y);
		batch.draw(rightPaddle.texture,rightPaddle.rectangle.x,rightPaddle.rectangle.y);
		batch.draw(ball.texture,ball.rectangle.x,ball.rectangle.y);
		batch.end();
		
		leftPaddle.handleInput();
		leftPaddle.keepInBounds();
		rightPaddle.keepInBounds();
		rightPaddle.paddleAi(ball);
		
		ball.keepInBounds();
		ball.detectCollision(ball.rectangle, leftPaddle.rectangle,rightPaddle.rectangle);
		
		if(ball.hitLeftWall)
		{
			rightPaddle.score++;
			System.out.println("Score " + leftPaddle.score + " : " + rightPaddle.score);
		}
		
		else if(ball.hitRightWall)
		{
			leftPaddle.score++;
			System.out.println("Score " + leftPaddle.score + " : " + rightPaddle.score);
		}
		
		if(leftPaddle.score == 9 || rightPaddle.score == 9)
		{
			pong.setScreen(new GameOverScreen(pong));
		}
	}
	
	@Override
	public void show()
	{
		fps = new FPSLogger();
		leftPaddle = new Paddle(100,300,10,42);
		rightPaddle = new Paddle(700,300,10,42);
		ball = new Ball(400,300,25,25);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,600);
		font = new BitmapFont(Gdx.files.internal("Fonts/pongFont.fnt"),Gdx.files.internal("Fonts/pongFont.png"),false);
		net = new Texture(Gdx.files.internal("Graphics/Net.png"));
	}
	
	@Override
	public void dispose()
	{
		net.dispose();
		leftPaddle.texture.dispose();
		rightPaddle.texture.dispose();
		ball.texture.dispose();
		ball.disposeOfSounds();
		font.dispose();
		batch.dispose();
	}
	
	@Override
	public void resize(int width, int height){}
	
	@Override
	public void hide(){}

	@Override
	public void pause(){}

	@Override
	public void resume(){}


}
