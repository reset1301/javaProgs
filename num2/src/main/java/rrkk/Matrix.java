package rrkk;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;

public class Matrix {
    private int[][] a, b, c;

    public Matrix(int colsA, int rowsA, int colsB, int rowsB) {
        this.a = new int[colsA][rowsA];
        this.b = new int[colsB][rowsB];
        randomMatrix(a);
        randomMatrix(b);
        multipleMatrix();
    }

    public int[][] getC() {
        return c;
    }

    public void printC(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(String.format("%7d ", c[i][j]));
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private void multipleMatrix() {
        c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    c[i][j] += a[i][k] * b[k][j];
    }

    private void randomMatrix(final int[][] matrix) {
        final Random random = new Random();  // Генератор случайных чисел.

        for (int row = 0; row < matrix.length; ++row)           // Цикл по строкам матрицы.
            for (int col = 0; col < matrix[row].length; ++col)  // Цикл по столбцам матрицы.
                matrix[row][col] = random.nextInt(100);         // Случайное число от 0 до 100.
//        printC(matrix);
    }
}
