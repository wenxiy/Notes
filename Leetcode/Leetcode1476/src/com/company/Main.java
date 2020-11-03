package com.company;

class SubrectangleQueries {
    public int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int j = row1;j<=row2;j++){
            for (int i = col1;i<=col2;i++){
                rectangle[j][i] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}

public class Main {

    public static void main(String[] args) {
        int[][] rectangleTest = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        SubrectangleQueries obj = new SubrectangleQueries(rectangleTest);
        System.out.println(obj.rectangle[0][1]);
    }
}
