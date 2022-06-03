package com.cs.test.paint.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class LineUtilityTest {

    @Test
    public void testHorizontalLine() {

        String[][] expectedResult = new String[6][22];
        expectedResult[2][1] = "x";
        expectedResult[2][2] = "x";
        expectedResult[2][3] = "x";
        expectedResult[2][4] = "x";
        expectedResult[2][5] = "x";
        expectedResult[2][6] = "x";

        String[][] input = new String[6][22];
        LineUtility.fillLine(input, 1, 2, 6, 2);
        Assert.assertArrayEquals(expectedResult, input);
    }

    @Test
    public void testVerticalLine() {

        String[][] expectedResult = new String[6][22];
        expectedResult[3][6] = "x";
        expectedResult[4][6] = "x";

        String[][] input = new String[6][22];
        LineUtility.fillLine(input, 6, 3, 6, 4);
        Assert.assertArrayEquals(expectedResult, input);
    }

    @Test
    public void testInvalidInputs() {

        String[][] expectedResult = new String[6][22];

        String[][] input = new String[6][22];
        LineUtility.fillLine(input, 5, 3, 6, 4);
        Assert.assertArrayEquals(expectedResult, input);
    }

    @Test
    public void testInvalidInputsOutOfIndex_1() {

        String[][] expectedResult = new String[4][5];

        String[][] input = new String[4][5];
        LineUtility.fillLine(input, 10, 3, 10, 4);
        Assert.assertArrayEquals(expectedResult, input);
    }

    @Test
    public void testInvalidInputsOutOfIndex_2() {

        String[][] expectedResult = new String[4][5];

        String[][] input = new String[4][5];
        LineUtility.fillLine(input, 3, 6, 3, 6);
        Assert.assertArrayEquals(expectedResult, input);
    }

}
