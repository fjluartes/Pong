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

    /**
     * Ball colliding with the left paddle.
     */
    public static void collidePaddle(
            Ball ball,
            Paddle paddle) {

        if (ball.xSpeed < 0 && collidesWith(
                ball.x,
                ball.y,
                ball.size,
                paddle.x,
                paddle.y,
                paddle.width,
                paddle.height)) {

            // Push ball outside the paddle
            ball.x = paddle.x + paddle.width + ball.size;

            // Bounce
            ball.xSpeed = -ball.xSpeed;
        }
    }

    /**
     * Ball colliding with the right paddle.
     */
    public static void collidePaddleAI(
            Ball ball,
            PaddleAI paddle) {

        if (ball.xSpeed > 0 && collidesWith(
                ball.x,
                ball.y,
                ball.size,
                paddle.x,
                paddle.y,
                paddle.width,
                paddle.height)) {

            // Push ball outside the paddle
            ball.x = paddle.x - ball.size;

            // Bounce
            ball.xSpeed = -ball.xSpeed;
        }
    }
}