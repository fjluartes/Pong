package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	PaddleAI paddleAI;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(20, 40, 8, 7, 7);
		paddle = new Paddle(60, 20, 10, 50);
		paddleAI = new PaddleAI(Gdx.graphics.getWidth() - 70, 20, 10, 50);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.rect((float)Gdx.graphics.getWidth() / 2, 0, 1, Gdx.graphics.getHeight());
		update();
		logic();
		draw();
		shape.end();
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

	private void draw() {
		ball.draw(shape);
		paddle.draw(shape);
		paddleAI.draw(shape);
	}
}
