package com.mygdx.pong;

public final class Util {

    // Prevent instantiation of this utility class.
    private Util() {
    }


    /**
     * Checks collision between a ball and a paddle.
     *
     * @param ballX    Ball center X
     * @param ballY    Ball center Y
     * @param ballSize Ball radius/half-size
     * @param paddleX  Paddle X
     * @param paddleY  Paddle Y
     * @param paddleWidth  Paddle width
     * @param paddleHeight  Paddle height
     * @return true if the ball overlaps the paddle
     */
    public static boolean collidesWith(
            int ballX,
            int ballY,
            int ballSize,
            int paddleX,
            int paddleY,
            int paddleWidth,
            int paddleHeight) {

        return ballX + ballSize >= paddleX
                && ballX - ballSize <= paddleX + paddleWidth
                && ballY + ballSize >= paddleY
                && ballY - ballSize <= paddleY + paddleHeight;
    }

    public static boolean collidesWith(Ball ball, Paddle paddle) {
        return collidesWith(
                ball.x,
                ball.y,
                ball.size,
                paddle.x,
                paddle.y,
                paddle.width,
                paddle.height
        );
    }

    public static boolean collidesWith(Ball ball, PaddleAI paddleAI) {
        return collidesWith(
                ball.x,
                ball.y,
                ball.size,
                paddleAI.x,
                paddleAI.y,
                paddleAI.width,
                paddleAI.height
        );
    }
}