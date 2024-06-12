package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Pong extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(20, 40, 10, 5, 5);
		paddle = new Paddle(0, 20, 10, 50);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		paddle.update();
		ball.checkCollision(paddle);
		ball.draw(shape);
		paddle.draw(shape);
		shape.end();
	}
}
