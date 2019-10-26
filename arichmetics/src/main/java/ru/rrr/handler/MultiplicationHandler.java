package ru.rrr.handler;

import ru.rrr.enums.Level;

public class MultiplicationHandler implements Handler {
    private final int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    public String getExample(int maxCount) {
        int firstParam = nums[(int) (nums.length * Math.random()) % maxCount];
        int secondParam = nums[(int) (nums.length * Math.random())];

        return String.format("%2d * %2d =", firstParam, secondParam);
    }

    @Override
    public int getCount(Level difficultLevel) {
        int count;
        switch (difficultLevel) {
            case Easy:
                count = 3;
                break;
            case Medium:
                count = 6;
                break;
            case Hard:
            default:
                count = 8;
        }
        return count;
    }
}
