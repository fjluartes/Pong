package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PaddleAI {
    int x;
    int y;
    int width;
    int height;
    int ySpeed = 8;

    public PaddleAI(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // clamp to top & bottom
        if (y < 0)
            y = 0;
        else if (y > Gdx.graphics.getHeight() - height)
            y = Gdx.graphics.getHeight() - height;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += ySpeed;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}

