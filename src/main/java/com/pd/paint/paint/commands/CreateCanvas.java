package com.pd.paint.paint.commands;

import com.pd.paint.paint.Canvas;
import com.pd.paint.paint.utils.CommandsEnum;

/**
 * @author PraffulD
 */
public class CreateCanvas extends Paint {

    public CreateCanvas(Canvas canvas) {
        super(canvas);
    }

    @Override
    public String serviceCommand() {
        return CommandsEnum.CREATE_CANVAS.getCommand();
    }

    @Override
    public int writeToCanvas(String[] args, Canvas canvas) {
        System.out.println("Executing Create Canvas command,");

        int x = parseInt(args[1]);
        int y = parseInt(args[0]);

        if (x == 0 || y == 0) {
            System.out.println("Please enter non zero integer co-ordinates, eg. C 20 4");
        } else {
            create(canvas, x + 2, y + 2);
        }
        return 0;
    }

    @Override
    public boolean validateInputs(String[] args) {
        if (args.length < 2) {
            System.out.println("Please share length and width to create canvas, eg. C 20 4");
            return false;
        }
        return true;
    }

    private void create(Canvas canvas, int x, int y) {

        String[][] arr = canvas.createCanvas(x, y);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = " ";
                if (j == 0 || j == y - 1) {
                    arr[i][j] = "|";
                }
                if (i == 0 || i == x - 1) {
                    arr[i][j] = "-";
                }
            }
        }
    }
}
