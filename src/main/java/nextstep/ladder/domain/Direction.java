package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

/**
 * 각 Point의 좌/우 방향을 Direction으로 추상화
 *  - 각 Point의 좌/우 방향 정보를 가진다.
 *  - 현재 Point에서 다음 Point를 생성하는 역할
 */
public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(PointStrategy pointStrategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(pointStrategy.generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
