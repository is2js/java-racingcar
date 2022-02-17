package racingcar.domain;

public class Position {

    private static final String ERROR_POSITION_INVALID_RANGE_MESSAGE = "정상 범위(" + 0 + "이상)가 아닙니다";
    private static final int MIN_POSITION_VALUE = 0;
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        checkValidRangeOfPosition(position);
    }

    private static void checkValidRangeOfPosition(int position) {
        if (!(MIN_POSITION_VALUE <= position)) {
            throw new IllegalArgumentException(ERROR_POSITION_INVALID_RANGE_MESSAGE);
        }
    }

    public Position increase() {
        return new Position(this.position + 1);
    }

    public int toInt() {
        return this.position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Position position1 = (Position) object;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
