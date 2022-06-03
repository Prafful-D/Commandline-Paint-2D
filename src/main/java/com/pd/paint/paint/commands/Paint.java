package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;
import com.pd.paint.paint.utils.CommandsEnum;

/**
 * @author PraffulD
 */
public abstract class Paint implements Command {

    private Canvas canvas;

    Paint(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public int executeCommand(String[] args) {

        if (!CommandsEnum.QUIT.getCommand().equalsIgnoreCase(serviceCommand())
                && !CommandsEnum.CREATE_CANVAS.getCommand().equalsIgnoreCase(serviceCommand()) && !canvas.isCreated()) {
            System.out.println("Please create canvas before executing commands");
        } else if (!validateInputs(args)) {
            return 0;
        }
        int result = writeToCanvas(args, canvas);
        canvas.paint();
        return result;
    }

    protected int parseInt(String value) {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("Invalid inputs [" + value + "], please try again");
        }
        return result;
    }

    protected abstract boolean validateInputs(String[] args);

    protected abstract int writeToCanvas(String[] args, Canvas canvas);
}
