package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Pong extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	PaddleAI paddleAI;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(20, 40, 10, 2, 2);
		paddle = new Paddle(0, 20, 10, 50);
		paddleAI = new PaddleAI(Gdx.graphics.getWidth() - 10, 20, 10, 50);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.rect((float)Gdx.graphics.getWidth() / 2, 0, 1, Gdx.graphics.getHeight());
		ball.update();
		paddle.update();
		paddleAI.update();
		ball.checkCollision(paddle);
		ball.checkCollisionAI(paddleAI);
		ball.draw(shape);
		paddle.draw(shape);
		paddleAI.draw(shape);
		shape.end();
	}
}
