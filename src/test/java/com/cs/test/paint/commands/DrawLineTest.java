package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class DrawLineTest {

    @Test
    public void testServiceCommand() {

        DrawLine drawLine = new DrawLine(new Canvas());
        String command = drawLine.serviceCommand();

        Assert.assertEquals("L", command);
    }

    @Test
    public void testValidateInputs() {

        DrawLine drawLine = new DrawLine(new Canvas());
        String[] input = new String[4];
        boolean result = drawLine.validateInputs(input);

        Assert.assertTrue(result);
    }

    @Test
    public void testValidateInvalidInputs() {

        DrawLine drawLine = new DrawLine(new Canvas());
        String[] input = new String[2];
        boolean result = drawLine.validateInputs(input);

        Assert.assertFalse(result);
    }

    @Test
    public void testWriteToCanvas() {

        String[][] canvasArray = new String[4][5];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        DrawLine drawLine = new DrawLine(canvas);
        String[] input = new String[4];
        input[0] = "1";
        input[1] = "1";
        input[2] = "1";
        input[3] = "2";
        int result = drawLine.writeToCanvas(input, canvas);

        Assert.assertEquals(0, result);
        Assert.assertEquals("x", canvasArray[1][1]);
        Assert.assertEquals("x", canvasArray[2][1]);
    }

    @Test
    public void testWriteToCanvasOutOfIndex() {

        String[][] canvasArray = new String[4][5];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        DrawLine drawLine = new DrawLine(canvas);
        String[] input = new String[4];
        input[0] = "0";
        input[1] = "1";
        input[2] = "0";
        input[3] = "2";
        int result = drawLine.writeToCanvas(input, canvas);

        Assert.assertEquals(0, result);
    }
}
