package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    private int score1;
    private int score2;
    UI ui = new UI();

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

        if (y < 0 || y > Gdx.graphics.getHeight())
            ySpeed = -ySpeed;
        if (x < 0 || x > Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() / 2;
            y = Gdx.graphics.getHeight() / 2;
        }
        if (x < 0) {
            ui.setScore2(score2++);
        }
        else if (x > Gdx.graphics.getWidth()) {
            ui.setScore1(score1++);
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }
    
    public void checkCollision(Paddle paddle) {
    	Util.collidePaddle(this, paddle);
    }

    public void checkCollisionAI(PaddleAI paddleAI) {
    	Util.collidePaddleAI(this, paddleAI);
    }
}
