package ch.hslu.threadexercise.exercise.n1.balls;

import java.awt.geom.Ellipse2D;

public class Ball {

    public int getDiameter() {
        return diameter;
    }

    private int diameter;
    private int xPosition;
    private int yPosition;

    public String getColor() {
        return color;
    }

    private String color;

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isVisible() {
        return isVisible;
    }

    private boolean isVisible = true;

    public int getxSpeed() {
        return xSpeed;
    }

    private int xSpeed;

    public int getySpeed() {
        return ySpeed;
    }

    private int ySpeed;

    public Ball(int diameter, int xPosition, int yPosition, int xSpeed, int ySpeed, String color) {
        this.diameter = diameter;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    public int getX() {
        return this.xPosition;
    }
    public void setX(int x) {this.xPosition = x; }

    public int getY() {
        return yPosition;
    }
    public void setY(int y) {this.yPosition = y; }


    public void changeColor(String newColor) {
        color = newColor;
    }
}
