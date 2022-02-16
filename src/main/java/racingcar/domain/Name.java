package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE =
            CAR_NAME_MIN_LENGTH + "~" + CAR_NAME_MAX_LENGTH + " 글자 범위 내에서 입력하세요.";

    public Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validateName(name);
        return new Name(name);
    }

    private static void validateName(String name) {
        checkValidLengthOfName(name);
    }

    private static void checkValidLengthOfName(String name) {
        int nameLength = name.length();
        if (!(CAR_NAME_MIN_LENGTH <= nameLength && nameLength <= CAR_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Name name1 = (Name) object;

        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
