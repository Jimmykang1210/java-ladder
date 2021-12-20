package nextstep.ladder.domain;

import java.util.Objects;

public class Layer {
    private static final String EXCEPTION_MESSAGE_MIN_LAYER = "사다리 높이가 1보다 작은 수 입니다.";
    private static final String EXCEPTION_MESSAGE_MIN_NOW_LAYER = "현재 높이가 1보다 작은 수 입니다.";
    private static final String EXCEPTION_MESSAGE_MAX_LAYER = "현재 높이가 사다리 높이보다 클 수 없습니다.";
    private static final int MIN_INPUT_NUMBER = 1;
    private static final int START_LAYER = 1;

    private final int layer;
    private int nowLayer;

    public Layer(int layer) {
        this(layer, START_LAYER);
    }

    public Layer(int layer, int nowLayer) {
        validateLayer(layer, nowLayer);
        this.layer = layer;
        this.nowLayer = nowLayer;
    }

    private void validateLayer(int layer, int nowLayer) {
        if (layer < MIN_INPUT_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_LAYER);
        }

        if (nowLayer < MIN_INPUT_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_NOW_LAYER);
        }

        if (layer < nowLayer) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MAX_LAYER);
        }
    }

    public void nextLayer() {
        nowLayer++;
    }

    public boolean moreLayer() {
        return layer >= nowLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layer layer1 = (Layer) o;
        return layer == layer1.layer && nowLayer == layer1.nowLayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer, nowLayer);
    }
}
