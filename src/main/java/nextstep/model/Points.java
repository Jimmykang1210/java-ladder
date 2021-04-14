package nextstep.model;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Boolean> points;

    public Points() {
        this.points = new ArrayList<>();
    }

    public void add(boolean point) {
        points.add(point);
    }

    public int size() {
        return this.points.size();
    }
}
