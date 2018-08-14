package rrkk;

import java.util.ArrayList;
import java.util.Random;

public class OptimizedArrayList {
    private ArrayList<Integer> a, b, c;
    private int colsA, rowsA, colsB, rowsB;

    public OptimizedArrayList(int colsA, int rowsA, int colsB, int rowsB) {
        a = new ArrayList<>(colsA * rowsA);
        b = new ArrayList<>(colsB * rowsB);
        c = new ArrayList<>(colsA * rowsB);
        this.colsA = colsA;
        this.rowsA = rowsA;
        this.colsB = colsB;
        this.rowsB = rowsB;
        randomMatrix(a, colsA, rowsA);
        randomMatrix(b, colsB, rowsB);
        multipleMatrix();
    }

    public ArrayList<Integer> getC() {
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
                System.out.print(String.format("%7d ", c.get(rowsB * i + j)));
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private void multipleMatrix() {
        for (int i = 0; i < colsA; i++)
            for (int j = 0; j < rowsB; j++)
                for (int k = 0; k < rowsA; k++) {
                    if (c.size() <= i * rowsB + j)
                        c.add(i * rowsB + j, a.get(i * rowsA + k) * b.get(k * rowsB + j));
                    else
                        c.add(i * rowsB + j, c.get(i * rowsB + j) + a.get(i * rowsA + k) * b.get(k * rowsB + j));
                }
    }

    private void randomMatrix(final ArrayList<Integer> matrix, int colsA, int rowsA) {
        final Random random = new Random();  // Генератор случайных чисел.

        for (int row = 0; row < rowsA; ++row)           // Цикл по строкам матрицы.
            // Цикл по столбцам матрицы.
            for (int col = 0; col < colsA; ++col)
                matrix.add(row * colsA + col, random.nextInt(100));         // Случайное число от 0 до 100.
//        printC(matrix,colsA,rowsA);
    }

}
