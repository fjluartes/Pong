package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PaddleAI {
    int x;
    int y;
    int width;
    int height;

    public PaddleAI(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        int ySpeed = 5;
        y += ySpeed;
        if (y > Gdx.graphics.getHeight() - height) {
            y -= ySpeed;
        }
        if (y < 0) {
            y += ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}

