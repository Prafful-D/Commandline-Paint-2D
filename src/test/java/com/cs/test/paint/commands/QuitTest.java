package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class QuitTest {

    @Test
    public void testServiceCommand() {

        Quit quit = new Quit(new Canvas());
        String command = quit.serviceCommand();

        Assert.assertEquals("Q", command);
    }

    @Test
    public void testValidateInputs() {

        Quit quit = new Quit(new Canvas());
        String[] input = new String[0];
        boolean result = quit.validateInputs(input);

        Assert.assertTrue(result);
    }

    @Test
    public void testWriteToCanvas() {

        Canvas canvas = new Canvas();
        Quit quit = new Quit(canvas);
        String[] input = new String[0];

        int result = quit.writeToCanvas(input, canvas);
        String[][] resultArr = canvas.getArray();

        Assert.assertEquals(1, result);
        Assert.assertFalse(canvas.isCreated());
        Assert.assertNull(resultArr);
    }
}