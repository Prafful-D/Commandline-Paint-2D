package com.cs.test.paint.commands;

import com.cs.test.paint.Canvas;
import com.cs.test.paint.utils.CommandsEnum;

/**
 * @author PraffulD
 */
public class Quit extends Paint {

    public Quit(Canvas canvas) {
        super(canvas);
    }

    @Override
    public String serviceCommand() {
        return CommandsEnum.QUIT.getCommand();
    }

    @Override
    protected int writeToCanvas(String[] args, Canvas canvas) {
        System.out.println("Executing Quit Paint Command,");

        canvas.setArray(null);
        System.out.println("Exiting Program... Thank You...");
        return 1;
    }

    @Override
    public boolean validateInputs(String[] args) {
        return true;
    }
}
