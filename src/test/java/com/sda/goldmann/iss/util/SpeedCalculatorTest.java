package com.sda.goldmann.iss.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedCalculatorTest {

    @Test
    public void testDistance() {
        double distanceActual = SpeedCalculator.distance(32.9697f, -96.80322f, 29.46786f, -98.53506f, "K");

        Assertions.assertEquals(
                422.73878539286306, //expected
                distanceActual
        );
    }

    @Test
    public void testSpeed() {
        double speedActual = SpeedCalculator.speed(100d, 3600);

        Assertions.assertEquals(
                100d, //expected
                speedActual
        );

        double speedActual2 = SpeedCalculator.speed(200d, 3600 / 2);

        Assertions.assertEquals(
                400d, //expected
                speedActual2
        );
    }
}
