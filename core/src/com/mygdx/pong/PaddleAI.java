package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PaddleAI {
    int x;
    int y;
    int width;
    int height;
    int ySpeed = 5;

    public PaddleAI(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        y += ySpeed;
        if (y > Gdx.graphics.getHeight() - height) {
            y = Gdx.graphics.getHeight() - height;
            ySpeed = -ySpeed;
        }
        if (y < 0) {
            y = 0;
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}

