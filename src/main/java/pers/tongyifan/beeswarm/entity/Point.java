package pers.tongyifan.beeswarm.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Implements beeswarm plot in Java
 * Main algorithm based on gyaikhom/beeswarm, thanks!!!
 *
 * @author tongyifan@TJU
 * @date 6/3/18
 */
public class Point implements Serializable{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
