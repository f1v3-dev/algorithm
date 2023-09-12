package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {

    @Test
    @DisplayName("gcd Test")
    void gcdTest() {
        int gcd = Main.gcd(10, 20);
        Assertions.assertEquals(10, gcd);
    }

    @Test
    @DisplayName("solution Test")
    void solutionTest() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(20, Main.solution(arr));

        int[] arr2 = {5, 7, 12};
        assertEquals(1, Main.solution(arr2));
    }

}