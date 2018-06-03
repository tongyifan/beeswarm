package pers.tongyifan.beeswarm;

import org.junit.jupiter.api.Test;
import pers.tongyifan.beeswarm.entity.Point;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tongyifan@TJU
 * @date 6/3/18
 */
class BeeswarmTest {
    @Test
    public void testSwarm() {
        double min = 10d;
        double max = 300d;
        int num_data = 200;
        int xaxis = 200;
        int radius = 3;
        List<Point> data = new ArrayList<>();
        for (int i = 0; i < num_data; i++) {
            data.add(new Point(0d, min + Math.random() * (max - min)));
        }
        System.out.println(Beeswarm.swarm(data, xaxis, radius));
    }
}