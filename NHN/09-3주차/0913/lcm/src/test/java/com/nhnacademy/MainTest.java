package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void lcmTest() {
        int[][] arr = {{1, 1}, {98, 49}, {2, 81}, {3, 7}, {19, 87}, {1, 40}};
        int[] result = {1, 98, 162, 21, 1653, 40};

        int index = 0;
        for (int[] ints : arr) {
            assertEquals(result[index++], Main.solution(ints[0], ints[1]));
        }
    }

}