package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > Gdx.graphics.getWidth())
            xSpeed = -xSpeed;
        if (y < 0 || y > Gdx.graphics.getHeight())
            ySpeed = -ySpeed;
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }
    
    public void checkCollision(Paddle paddle) {
    	if (collidesWith(paddle))
    		xSpeed = -xSpeed;
    }

    public void checkCollisionAI(PaddleAI paddleAI) {
    	if (collidesWithAI(paddleAI))
    		xSpeed = -xSpeed;
    }
    
    public boolean collidesWith(Paddle paddle) {
        return x + size >= paddle.x && x - size <= paddle.x + paddle.width &&
                y + size >= paddle.y && y - size <= paddle.y + paddle.height;
    }

    public boolean collidesWithAI(PaddleAI paddleAI) {
        return x + size >= paddleAI.x && x - size <= paddleAI.x + paddleAI.width &&
                y + size >= paddleAI.y && y - size <= paddleAI.y + paddleAI.height;
    }
}
