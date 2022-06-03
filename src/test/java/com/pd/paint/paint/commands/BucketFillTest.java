package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class BucketFillTest {

    @Test
    public void testServiceCommand() {

        BucketFill bucketFill = new BucketFill(new Canvas());
        String command = bucketFill.serviceCommand();

        Assert.assertEquals("B", command);
    }

    @Test
    public void testValidateInputs() {

        BucketFill bucketFill = new BucketFill(new Canvas());
        String[] input = new String[3];
        boolean result = bucketFill.validateInputs(input);

        Assert.assertTrue(result);
    }

    @Test
    public void testValidateInvalidInputs() {

        BucketFill bucketFill = new BucketFill(new Canvas());
        String[] input = new String[2];
        boolean result = bucketFill.validateInputs(input);

        Assert.assertFalse(result);
    }

    @Test
    public void testWriteToCanvas() {

        String[][] canvasArray = new String[4][4];
        Canvas canvas = new Canvas();
        canvas.setArray(canvasArray);

        BucketFill bucketFill = new BucketFill(canvas);
        String[] input = new String[4];
        input[0] = "2";
        input[1] = "2";
        input[2] = "o";
        int result = bucketFill.writeToCanvas(input, canvas);
        String[][] resultArr = canvas.getArray();

        Assert.assertEquals(0, result);
        Assert.assertEquals(4, resultArr.length);
        Assert.assertEquals(4, resultArr[0].length);
        Assert.assertEquals("o", resultArr[1][1]);
        Assert.assertEquals("o", resultArr[1][2]);

    }
}
