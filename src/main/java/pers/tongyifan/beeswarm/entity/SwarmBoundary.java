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
public class SwarmBoundary implements Serializable {
    private int index;
    private double x;
    private double y;
    private int radius;

    @Override
    public String toString() {
        return "SwarmBoundary{" +
                "index=" + index +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }

    public SwarmBoundary() {
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public SwarmBoundary(int index, double x, double y, int radius) {

        this.index = index;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
