package rrkk;

import java.util.Random;

public class OptimizedMatrix {
    private int[] a, b, c;
    private int colsA, rowsA, colsB, rowsB;

    public OptimizedMatrix(int colsA, int rowsA, int colsB, int rowsB) {
        a = new int[colsA * rowsA];
        b = new int[colsB * rowsB];
        c = new int[colsA * rowsB];
        this.colsA = colsA;
        this.rowsA = rowsA;
        this.colsB = colsB;
        this.rowsB = rowsB;
        randomMatrix(a, colsA, rowsA);
        randomMatrix(b, colsB, rowsB);
        multipleMatrix();
    }

    public int[] getC() {
        return c;
    }

    public int getColsA() {
        return colsA;
    }

    public int getRowsB() {
        return rowsB;
    }

    public void printC() {
        for (int i = 0; i < colsA; i++) {
            for (int j = 0; j < rowsB; j++) {
                System.out.print(String.format("%7d ", c[rowsB * i + j]));
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private void multipleMatrix() {
        for (int i = 0; i < colsA; i++)
            for (int j = 0; j < rowsB; j++)
                for (int k = 0; k < rowsA; k++)
                    c[i * rowsB + j] += a[i * rowsA + k] * b[k * rowsB + j];
    }

    private void randomMatrix(final int[] matrix, int colsA, int rowsA) {
        final Random random = new Random();  // Генератор случайных чисел.

        for (int row = 0; row < rowsA; ++row)           // Цикл по строкам матрицы.
            // Цикл по столбцам матрицы.
            for (int col = 0; col < colsA; ++col)
                matrix[row * colsA + col] = random.nextInt(100);         // Случайное число от 0 до 100.
//        printC(matrix,colsA,rowsA);
    }
}
