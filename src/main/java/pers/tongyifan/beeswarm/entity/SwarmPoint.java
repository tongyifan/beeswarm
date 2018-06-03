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
public class SwarmPoint implements Serializable {
    private int index;
    private Boolean isEnd;
    private Boolean isValid;
    private double x;
    private double y;

    @Override
    public String toString() {
        return "SwarmPoint{" +
                "index=" + index +
                ", isEnd=" + isEnd +
                ", isValid=" + isValid +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getEnd() {
        return isEnd;
    }

    public void setEnd(Boolean end) {
        isEnd = end;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
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

    public SwarmPoint() {

    }

    public SwarmPoint(int index, Boolean isEnd, Boolean isValid, double x, double y) {

        this.index = index;
        this.isEnd = isEnd;
        this.isValid = isValid;
        this.x = x;
        this.y = y;
    }
}
