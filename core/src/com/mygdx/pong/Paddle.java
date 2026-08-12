package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    int speed = 8;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // clamp to top & bottom
        if (y < 0)
            y = 0;
        if (y > Gdx.graphics.getHeight() - height)
            y = Gdx.graphics.getHeight() - height;

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            y = Gdx.graphics.getHeight() - (int)touchPos.y; // flip mouseY click
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= speed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
