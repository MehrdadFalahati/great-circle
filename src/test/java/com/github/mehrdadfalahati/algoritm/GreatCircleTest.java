package com.github.mehrdadfalahati.algoritm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatCircleTest {

    @Test
    void test_find_distance_two_locations_lesser_than_twenty() {
        double calculate = GreatCircle.calculate(35.795409, 51.514007);
        assertTrue(calculate <= 20);
    }

    @Test
    void test_find_distance_two_locations_greater_than_twenty() {
        double calculate = GreatCircle.calculate(35.740033, 51.825203);
        assertTrue(calculate > 20);
    }

    @Test
    void test_find_distance_two_locations_when_is_zero() {
        double calculate = GreatCircle.calculate(0, 0);
        assertTrue(calculate > 20);
    }

}