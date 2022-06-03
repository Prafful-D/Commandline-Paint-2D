package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import com.cs.test.paint.utils.CommandsEnum;
import com.cs.test.paint.utils.LineUtility;

/**
 * @author PraffulD
 */
public class DrawLine extends Paint {

    public DrawLine(Canvas canvas) {
        super(canvas);
    }

    @Override
    public String serviceCommand() {
        return CommandsEnum.DRAW_LINE.getCommand();
    }

    @Override
    protected int writeToCanvas(String[] args, Canvas canvas) {
        System.out.println("Executing Draw Line command,");

        int x1 = parseInt(args[0]);
        int y1 = parseInt(args[1]);
        int x2 = parseInt(args[2]);
        int y2 = parseInt(args[3]);

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            System.out.println("Out of index. Please enter non zero co-ordinates, eg. L 1 2 6 2");
        } else {
            LineUtility.fillLine(canvas.getArray(), x1, y1, x2, y2);
        }
        return 0;
    }

    @Override
    protected boolean validateInputs(String[] args) {
        if (args.length < 4) {
            System.out.println("Please share (x1,y1) and (x2,y2) co-ordinate to draw line, eg. L 1 2 6 2");
            return false;
        }
        return true;
    }
}
