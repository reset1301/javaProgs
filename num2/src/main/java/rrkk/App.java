package rrkk;

import java.util.Arrays;

public class App {

    private static final int INT = 32768;

    public static void main(String[] args) {
//        sortArrays();
//        System.out.println(new BigInteger("13").toString(2));
//        System.out.println(new BigInteger("38").toString(2));
        System.out.println(~(190 - 128 >> 31));
//        long start = System.currentTimeMillis();
//        Matrix matrix = new Matrix(200, 3000, 3000, 200);
//        matrix.printC(matrix.getC());
        sortArrays();
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        OptimizedMatrix optimizedMatrix = new OptimizedMatrix(200, 3000, 3000, 200);
////        optimizedMatrix.printC();
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        OptimizedArrayList optimizedArrayList = new OptimizedArrayList(20, 300, 300, 20);
////        optimizedArrayList.printC();
//        System.out.println(System.currentTimeMillis() - start);
    }


    private static void sortArrays() {
        long start = System.currentTimeMillis();
        int[] data = new int[INT];

        for (int i = 0; i < data.length; i++) data[i] = (int) (Math.random() * 256);

        Arrays.sort(data);

        long sum = 0;
        for (int i = 0; i < 100000; i++)
            for (int aData : data) {
                sum += ~((aData - 128) >> 31) & aData;
//                if (aData >= 128) sum += aData;
            }

        System.out.println(System.currentTimeMillis() - start);
    }
}