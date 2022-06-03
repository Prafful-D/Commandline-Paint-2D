package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class DrawRectangleTest {

    @Test
    public void testServiceCommand() {

        DrawRectangle drawRectangle = new DrawRectangle(new Canvas());
        String command = drawRectangle.serviceCommand();

        Assert.assertEquals("R", command);
    }

    @Test
    public void testValidateInputs() {

        DrawRectangle drawRectangle = new DrawRectangle(new Canvas());
        String[] input = new String[4];
        boolean result = drawRectangle.validateInputs(input);

        Assert.assertTrue(result);
    }

    @Test
    public void testValidateInvalidInputs() {

        DrawRectangle drawRectangle = new DrawRectangle(new Canvas());
        String[] input = new String[2];
        boolean result = drawRectangle.validateInputs(input);

        Assert.assertFalse(result);
    }

    @Test
    public void testWriteToCanvas() {

        String[][] canvasArray = new String[10][10];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        DrawRectangle drawRectangle = new DrawRectangle(canvas);
        String[] input = new String[4];
        input[0] = "2";
        input[1] = "2";
        input[2] = "6";
        input[3] = "6";
        int result = drawRectangle.writeToCanvas(input, canvas);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testWriteToCanvasOutOfIndex() {

        String[][] canvasArray = new String[10][10];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        DrawRectangle drawRectangle = new DrawRectangle(canvas);
        String[] input = new String[4];
        input[0] = "0";
        input[1] = "0";
        input[2] = "6";
        input[3] = "6";
        int result = drawRectangle.writeToCanvas(input, canvas);

        Assert.assertEquals(0, result);
    }
}
