package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;

/**
 * @author PraffulD
 */
public class BucketFill extends Paint {

    public BucketFill(Canvas canvas) {
        super(canvas);
    }

    @Override
    public String serviceCommand() {
        return "B";
    }

    @Override
    protected int writeToCanvas(String[] args, Canvas canvas) {

        System.out.println("Executing Fill Canvas command,");

        int x = parseInt(args[1]);
        int y = parseInt(args[0]);

        fillColor(canvas.getArray(), x, y, args[2]);
        return 0;
    }

    @Override
    public boolean validateInputs(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide input in correct format, eg. B 10 3 o");
            return false;
        }
        return true;
    }

    private void fillColor(String[][] canvas, int i, int j, String fillingValue) {

        String currentValue = canvas[i][j];
        if (i < 1 || i >= canvas.length - 1 || j < 1 || j >= canvas[i].length - 1
                || "x".equalsIgnoreCase(currentValue) || fillingValue.equalsIgnoreCase(currentValue)) {
            return;
        }
        canvas[i][j] = fillingValue;

        fillColor(canvas, i, j - 1, fillingValue);
        fillColor(canvas, i, j + 1, fillingValue);
        fillColor(canvas, i - 1, j, fillingValue);
        fillColor(canvas, i + 1, j, fillingValue);
    }
}
