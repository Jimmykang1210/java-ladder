package nextstep.ladder.painter;

import static java.util.stream.Collectors.*;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import nextstep.ladder.point.Point;
import nextstep.ladder.point.Points;

public class RandomPointPainter implements PointPainter {

	private final Random random = new Random();

	@Override
	public Points drawPoints(int count) {
		AtomicBoolean isConnectedToPreceding = new AtomicBoolean(false);

		return IntStream.range(0, count)
			.mapToObj(index -> drawPoint(index == count - 1, isConnectedToPreceding.get()))
			.peek(point -> isConnectedToPreceding.set(point.isConnectedToNextPoint()))
			.collect(collectingAndThen(toList(), Points::ofPoints));
	}

	@Override
	public Point drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return Point.ofPoint(false);
		}
		return Point.ofPoint(random.nextBoolean());
	}
}
