package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class PaintTest {

    @Test
    public void testExecuteCreateCommand() {

        Canvas canvas = new Canvas();
        CreateCanvas createCanvas = new CreateCanvas(canvas);
        String[] input = new String[2];
        input[0] = "2";
        input[1] = "2";
        int result = createCanvas.executeCommand(input);
        String[][] resultArr = canvas.getArray();

        Assert.assertEquals(0, result);
        Assert.assertTrue(canvas.isCreated());
        Assert.assertEquals(4, resultArr.length);
        Assert.assertEquals(4, resultArr[0].length);
    }

    @Test
    public void testExecuteCreateCommand_Validate() {

        Canvas canvas = new Canvas();
        CreateCanvas createCanvas = new CreateCanvas(canvas);
        String[] input = new String[1];
        input[0] = "2";
        int result = createCanvas.executeCommand(input);
        String[][] resultArr = canvas.getArray();

        Assert.assertEquals(0, result);
        Assert.assertFalse(canvas.isCreated());
    }

    @Test
    public void testExecuteLineCommand() {

        String[][] canvasArray = new String[4][5];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        DrawLine drawLine = new DrawLine(canvas);
        String[] input = new String[4];
        input[0] = "1";
        input[1] = "1";
        input[2] = "1";
        input[3] = "2";
        int result = drawLine.executeCommand(input);

        Assert.assertEquals(0, result);
    }
}
