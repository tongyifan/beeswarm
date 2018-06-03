package pers.tongyifan.beeswarm;

import pers.tongyifan.beeswarm.entity.Point;
import pers.tongyifan.beeswarm.entity.SwarmBoundary;
import pers.tongyifan.beeswarm.entity.SwarmDistance;
import pers.tongyifan.beeswarm.entity.SwarmPoint;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Implements beeswarm plot in Java
 * Main algorithm based on gyaikhom/beeswarm, thanks!!!
 *
 * @author tongyifan@TJU
 * @date 6/3/18
 */
public class Beeswarm {
    public static List<Point> swarm(List<Point> data, int xaxis, int radius) {
        data.sort((a, b) -> {
            if (a.getY() == b.getY()) {
                return 0;
            } else {
                return a.getY() > b.getY() ? 1 : -1;
            }
        });
        List<SwarmBoundary> swarmBoundary = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Map res = getX(i, data.get(i).getY(), swarmBoundary, xaxis, radius);
            swarmBoundary = (List<SwarmBoundary>) res.get("swarmBoundary");
            data.set(i, new Point(Double.parseDouble(res.get("x").toString()), data.get(i).getY()));
        }
        return data;
    }

    private static Map getX(int index, double y, List<SwarmBoundary> swarmBoundary, int xaxis, int radius) {
        List<SwarmPoint> isects = findCandidateIntervals(y, swarmBoundary);
        SwarmPoint preferredChoice = new SwarmPoint(index, false, true, xaxis, y);
        isects.add(preferredChoice);
        isects.add(preferredChoice);
        isects = removeInvalidIntervals(isects);
        double x = chooseX(isects, xaxis);
        swarmBoundary.add(new SwarmBoundary(index, x, y, radius));
        Map result = new HashMap();
        result.put("x", x);
        result.put("swarmBoundary", swarmBoundary);
        return result;
    }

    private static List<SwarmPoint> findCandidateIntervals(double height, List<SwarmBoundary> swarmBoundary) {
        List<SwarmPoint> possibleIntervals = new ArrayList<>();
        for (int i = 0; i < swarmBoundary.size(); i++) {
            List<SwarmPoint> isects = findIntersections(swarmBoundary.get(i), height);
            if (isects == null) {
                swarmBoundary.remove(i);
                i--;
                continue;
            }
            possibleIntervals.add(isects.get(0));
            possibleIntervals.add(isects.get(1));
        }
        return possibleIntervals;
    }

    private static List<SwarmPoint> findIntersections(SwarmBoundary circle, double height) {
        double effectiveHeight = height - circle.getY();
        int diameter = 2 * circle.getRadius();
        if (effectiveHeight - diameter > 0) {
            return null;
        }
        double x = Math.sqrt(diameter * diameter - effectiveHeight * effectiveHeight);
        List<SwarmPoint> points = new ArrayList<>();
        points.add(new SwarmPoint(circle.getIndex(), false, true, circle.getX() + x, height));
        points.add(new SwarmPoint(circle.getIndex(), false, true, circle.getX() - x, height));
        return points;
    }

    private static List<SwarmPoint> removeInvalidIntervals(List<SwarmPoint> intervals) {
        int len = intervals.size();
        List<SwarmPoint> validIntervals = new ArrayList<>();
        if (len < 1) {
            return validIntervals;
        }
        intervals.sort((a, b) -> {
            if (a.getX() == b.getX()) {
                if (a.getIndex() == b.getIndex()) {
                    return 0;
                } else {
                    return a.getIndex() > b.getIndex() ? 1 : -1;
                }
            }
            return a.getX() > b.getX() ? 1 : -1;
        });
        for (int i = 0; i < len - 1; i++) {
            if (intervals.get(i).getEnd()) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (intervals.get(i).getIndex() == intervals.get(j).getIndex()) {
                    intervals.get(j).setEnd(true);
                    break;
                } else {
                    intervals.get(j).setValid(false);
                }
            }
        }
        for (SwarmPoint interval : intervals) {
            if (interval.getValid()) {
                validIntervals.add(interval);
            }
        }
        return validIntervals;
    }

    private static double chooseX(List<SwarmPoint> intervals, int xaxis) {
        List<SwarmDistance> distance = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            distance.add(new SwarmDistance(i, Math.abs(xaxis - intervals.get(i).getX())));
        }
        distance.sort((a, b) -> {
            if (a.getDistance() == b.getDistance()) {
                return 0;
            } else {
                return a.getDistance() > b.getDistance() ? 1 : -1;
            }
        });
        return intervals.get(distance.get(0).getIndex()).getX();
    }
}
