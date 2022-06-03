package com.pd.paint.paint;

/**
 * @author PraffulD
 */
public class Canvas {

    private boolean isCreated;

    private String[][] array;

    public boolean isCreated() {
        return isCreated;
    }

    private void setCreated(boolean created) {
        isCreated = created;
    }

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    public String[][] createCanvas(int x, int y) {
        setCreated(true);
        array = new String[x][y];
        return array;
    }

    public void paint() {
        String[][] arr = this.getArray();

        if (arr != null) {
            int x = arr.length;
            int y = arr[0].length;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println("");
            }
        }
    }
}
