package chapter10;

import java.util.Arrays;

public class Task4 {

    private static int n = 6;

    public static void main(String[] args) {

        if(n == 0) {
            System.out.println(0);
            return;
        } else if(n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        Matrix[] matrices = new Matrix[n - 1];

        Matrix initialMatrix = new Matrix(2,2);

        initialMatrix.setValue(0,0, 1);
        initialMatrix.setValue(0,1, 1);
        initialMatrix.setValue(1,0, 1);
        initialMatrix.setValue(1,1, 0);

        Arrays.parallelSetAll(matrices, i -> initialMatrix);
        Arrays.parallelPrefix(matrices, Matrix::multiply);

        System.out.println(n +"'th fibonnaci number is " + matrices[n - 2].getValue(0,0));

    }

    private static class Matrix {
        private int rows;
        private int columns;

        int[][] matrix;

        private Matrix(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new int[rows][columns];
        }


        private void setValue(int row, int column, int value) {
            matrix[row][column] = value;
        }

        private int getValue(int row, int column) {
            return matrix[row][column];
        }

        private Matrix multiply(Matrix matrix) {

            if(this.columns != matrix.rows) {
                throw new IllegalArgumentException("Second matrix has to have same amount of rows as columns of the second one");
            }

            int n = this.rows;
            int p = this.columns;
            int m = matrix.columns;

            Matrix resultMatrix = new Matrix(this.rows, matrix.columns);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {

                    int value = 0;

                    for(int k = 0; k < p; k++) {
                        value += this.matrix[i][k] * matrix.matrix[k][j];
                    }

                    resultMatrix.matrix[i][j] = value;
                }
            }

            return resultMatrix;
        }

    }
}
