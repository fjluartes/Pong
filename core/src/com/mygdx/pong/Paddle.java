package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class Paddle {
    int x;
    int y;
    int width;
    int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            System.out.println("y " + y);
            System.out.println("touchPos.y " + touchPos.y);
            y = (int)touchPos.y;
            if (y < 0)
                y = 0;
            if (y > Gdx.graphics.getHeight() - height)
                y = Gdx.graphics.getHeight() - height;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
