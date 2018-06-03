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
public class SwarmDistance implements Serializable {
    private int index;
    private double distance;

    @Override
    public String toString() {
        return "SwarmDistance{" +
                "index=" + index +
                ", distance=" + distance +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public SwarmDistance() {

    }

    public SwarmDistance(int index, double distance) {

        this.index = index;
        this.distance = distance;
    }
}
