package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class CreateCanvasTest {

    @Test
    public void testServiceCommand() {

        CreateCanvas createCanvas = new CreateCanvas(new Canvas());
        String command = createCanvas.serviceCommand();

        Assert.assertEquals("C", command);
    }

    @Test
    public void testValidateInputs() {

        CreateCanvas createCanvas = new CreateCanvas(new Canvas());
        String[] input = new String[2];
        boolean result = createCanvas.validateInputs(input);

        Assert.assertTrue(result);
    }

    @Test
    public void testValidateInvalidInputs() {

        CreateCanvas createCanvas = new CreateCanvas(new Canvas());
        String[] input = new String[1];
        boolean result = createCanvas.validateInputs(input);

        Assert.assertFalse(result);
    }

    @Test
    public void testWriteToCanvas() {

        Canvas canvas = new Canvas();
        CreateCanvas createCanvas = new CreateCanvas(canvas);
        String[] input = new String[4];
        input[0] = "2";
        input[1] = "2";
        int result = createCanvas.writeToCanvas(input, canvas);
        String[][] resultArr = canvas.getArray();

        Assert.assertEquals(0, result);
        Assert.assertTrue(canvas.isCreated());
        Assert.assertEquals(4, resultArr.length);
        Assert.assertEquals(4, resultArr[0].length);
    }
}
