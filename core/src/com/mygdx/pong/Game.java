package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private PaddleAI paddleAI;
	private BitmapFont font;
	
	@Override
	public void create () {
		int paddleWidth = 10;
		int paddleHeight = 50;
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		FreeTypeFontGenerator generator;
		FreeTypeFontGenerator.FreeTypeFontParameter parameter;

		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		ball = new Ball(20, 40, 8, 7, 7);
		paddle = new Paddle(60, (screenWidth - 10) / 2, paddleWidth, paddleHeight);
		paddleAI = new PaddleAI(screenWidth - 70, (screenHeight - 10) / 2, paddleWidth, paddleHeight);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Kenney-Bold.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24;
		parameter.color = Color.WHITE;
		font = generator.generateFont(parameter);
		generator.dispose();
	}

	@Override
	public void render () {
		update();
		logic();
		draw();
	}

	private void update() {
		ball.update();
		paddle.update();
		paddleAI.update();
	}

	private void logic() {
		ball.checkCollision(paddle);
		ball.checkCollisionAI(paddleAI);
	}

	// (0, 0) is in bottom left corner of screen
	private void draw() {
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.rect((float)screenWidth / 2, 0, 1, screenHeight);
		ball.draw(shape);
		paddle.draw(shape);
		paddleAI.draw(shape);
		shape.end();

		batch.begin();
		font.draw(batch, "0", screenWidth - 600, screenHeight - 50);
		font.draw(batch, "0", screenWidth - 200, screenHeight - 50);
		batch.end();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
