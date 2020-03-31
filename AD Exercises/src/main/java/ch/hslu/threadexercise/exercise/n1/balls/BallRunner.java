package ch.hslu.threadexercise.exercise.n1.balls;

import java.awt.geom.Ellipse2D;

public class BallRunner implements Runnable {
    private static final int ballsCount = 40;
    private static final int maxBallSize = 100;
    private static final String[] colors = {"red", "black", "blue", "yellow", "green", "magenta", "white"};
    private boolean isRunning = false;
    private Ball[] balls;

    public void stop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.initialize();
        this.execute();
    }

    private void execute() {
        while (isRunning ){
            for (var ball : this.balls){
                erase(ball);
                this.moveBall(ball);
                draw(ball);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Ball ball) {
        if (ball.isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(ball, ball.getColor(), new Ellipse2D.Double(ball.getX(), ball.getY(),
                    ball.getDiameter(), ball.getDiameter()));
        }
    }

    private void erase(Ball ball) {
        if (ball.isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(ball);
        }
    }

    private void moveBall(Ball ball){
        ball.setX(ball.getX() + ball.getxSpeed());
        ball.setY(ball.getY() + ball.getySpeed());
    }

    private void initialize(){
        this.isRunning = true;
        var canvas = Canvas.getCanvas();
        balls = new Ball[ballsCount];
        for (var i = 0; i < ballsCount; i++){
            balls[i] = new Ball(random(maxBallSize), random(canvas.getWidth()), random(canvas.getHeight()), random(5) + 1, random(2) + 1, colors[random(colors.length)]);
        }
    }

    private static int random(int max){
        return (int)(Math.random() * max);
    }
}