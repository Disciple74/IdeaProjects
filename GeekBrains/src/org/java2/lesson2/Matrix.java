package org.java2.lesson2;

public class Matrix {
    private String str = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private String[][] matrix = new String[4][4];

    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public String[][] getMatrix() {
        return matrix;
    }

    public void stringToMatrix(){
        if (getStr() == null){
            throw new IllegalArgumentException("Empty string");
        }
        char[] buffer = getStr().toCharArray();
        for (int i = 0, j = 0, i1 = 0; i < buffer.length; i++){
            if (buffer[i]!=' ') {
                if (buffer[i] != '\n') matrix[j][i1++] = String.valueOf(buffer[i]);
                else {
                    j++;
                    i1 = 0;
                }
            }
        }
    }

    public int toIntMatrix(){
        if (getMatrix() == null){
            throw new IllegalArgumentException("Empty string");
        }
        int[][] matrix = new int[4][4];
        int i = 0, j = 0;
        for (String[] buffer : getMatrix()) {
            for (String bufferChar : buffer) {
                matrix[j][i++] += Integer.valueOf(bufferChar);
            }
            j++;
            i = 0;
        }
        return sum(matrix);
    }

    private int sum(int[][] matrix){
        if (matrix == null){
            throw new IllegalArgumentException("Empty matrix");
        }
        int sum = 0;
        for (int[] i : matrix){
            for (int j : i){
                sum += j;
            }
        }
        sum/=2;
        return sum;
    }
}
