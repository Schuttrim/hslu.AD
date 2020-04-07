package ch.hslu.threadexercise.exercise.n1.balls;

import java.awt.*;

public class BallsProgram {

    public static void main(String[] args){
        var runner = new BallRunner();
        var thread = new Thread(runner);

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
