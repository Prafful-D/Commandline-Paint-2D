package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;
import com.pd.paint.paint.utils.LineUtility;

/**
 * @author PraffulD
 */
public class DrawRectangle extends Paint {

    public DrawRectangle(Canvas canvas) {
        super(canvas);
    }

    @Override
    public String serviceCommand() {
        return "R";
    }

    @Override
    protected int writeToCanvas(String[] args, Canvas canvas) {
        System.out.println("Executing Draw Rectangle command,");

        int x1 = parseInt(args[0]);
        int y1 = parseInt(args[1]);
        int x2 = parseInt(args[2]);
        int y2 = parseInt(args[3]);

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            System.out.println("Out of index. Please enter non zero co-ordinates, eg. R 14 1 18 3");
        } else {
            LineUtility.fillLine(canvas.getArray(), x1, y1, x2, y1);
            LineUtility.fillLine(canvas.getArray(), x1, y1, x1, y2);
            LineUtility.fillLine(canvas.getArray(), x1, y2, x2, y2);
            LineUtility.fillLine(canvas.getArray(), x2, y1, x2, y2);
        }
        return 0;
    }

    @Override
    public boolean validateInputs(String[] args) {
        boolean result = true;
        if (args.length < 4) {
            System.out.println("Please share (x1,y1) and (x2,y2) co-ordinate to draw line, eg. R 14 1 18 3");
            result = false;
        }
        return result;
    }
}
