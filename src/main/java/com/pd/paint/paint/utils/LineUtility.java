package com.pd.paint.paint.utils;

/**
 * @author PraffulD
 */
public class LineUtility {

    public static void fillLine(String[][] arr, int x1, int y1, int x2, int y2) {

        if (y1 == y2) {
            fillHorizontalLine(arr, x1, y1, x2);
        } else if (x1 == x2) {
            fillVerticalLine(arr, x1, y1, y2);
        } else {
            System.out.println("Only horizontal and vertical lines can be drawn");
        }
    }

    private static void fillVerticalLine(String[][] arr, int x1, int y1, int y2) {

        int arrRowLength = arr.length - 1;
        int arrColumnLength = arr[0].length - 1;

        if (x1 >= arrColumnLength) {
            System.out.println("Out of index. Please enter X co-ordinates less then " + (arrColumnLength - 1));
            return;
        }
        int stop = y1 > y2 ? y1 : y2;
        int start = y1 == stop ? y2 : y1;
        if (stop >= arrRowLength) {
            stop = arrRowLength - 1;
        }
        int verticalLine = x1;

        for (int i = start; i <= stop; i++) {
            arr[i][verticalLine] = "x";
        }
    }

    private static void fillHorizontalLine(String[][] arr, int x1, int y1, int x2) {

        int arrRowLength = arr.length - 1;
        int arrColumnLength = arr[0].length - 1;

        if (y1 >= arrRowLength) {
            System.out.println("Out of index. Please enter Y co-ordinates less then " + (arrColumnLength - 1));
            return;
        }
        int start = x1 < x2 ? x1 : x2;
        int end = x1 == start ? x2 : x1;
        if (end >= arrColumnLength) {
            end = arrColumnLength - 1;
        }
        int horizontalLine = y1;

        for (int j = start; j <= end; j++) {
            arr[horizontalLine][j] = "x";
        }
    }
}
