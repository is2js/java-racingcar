package racingcar.util;

import java.util.Random;

public class RandomNumberGeneratePolicy implements NumberGeneratePolicy {
    public static final int RANDOM_MAXIMUM = 10;

    @Override
    public int generateNumber() {
        return new Random().nextInt(RANDOM_MAXIMUM);
    }
}