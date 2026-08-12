package com.mygdx.pong;

public final class Util {

    // Prevent instantiation of this utility class.
    private Util() {
    }

    /**
     * Axis-Aligned Bounding Box (AABB) collision check.
     *
     * Returns true if the two rectangles overlap.
     *
     * @param x1 top-left x of rectangle 1
     * @param y1 top-left y of rectangle 1
     * @param w1 width of rectangle 1
     * @param h1 height of rectangle 1
     * @param x2 top-left x of rectangle 2
     * @param y2 top-left y of rectangle 2
     * @param w2 width of rectangle 2
     * @param h2 height of rectangle 2
     * @return true if the rectangles collide, false otherwise
     */
    public static boolean collision(
            int x1, int y1, int w1, int h1,
            int x2, int y2, int w2, int h2) {

        return Math.max(x1, x2) < Math.min(x1 + w1, x2 + w2)
                && Math.max(y1, y2) < Math.min(y1 + h1, y2 + h2);
    }
}