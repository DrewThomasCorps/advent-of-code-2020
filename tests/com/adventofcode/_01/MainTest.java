package com.adventofcode._01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MainTest {

    @Test
    void getMultipleForList() {
        Assertions.assertEquals(514579,
                Main.getMultipleForList(Arrays.asList(1721, 979, 366, 299, 675, 1456))
        );
    }

    @Test
    void ThreeSum() {
        Assertions.assertEquals(241861950,
                Main.getThreeSum(Arrays.asList(1721, 979, 366, 299, 675, 1456))
        );
    }
}