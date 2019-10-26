package ru.rrr.handler;

import ru.rrr.enums.Level;

public class ArichmeticsHandler implements Handler {
    @Override
    public String getExample(int maxCount) {
        Sign sign = Math.random() > 0.5 ? Sign.plus : Sign.minus;
        int firstParam = maxCount / 3 + (int) Math.round(Math.random() * 2 * maxCount / 3);
        int secondParam = 1 +
                (sign.equals(Sign.plus)
                        ? (int) Math.round((maxCount - firstParam) * Math.random())
                        : (int) Math.round(firstParam * Math.random()));

        return String.format("%4d %s %4d =", firstParam,
                (sign.equals(Sign.plus) ? " + " : " - "),
                secondParam);
    }

    @Override
    public int getCount(Level difficultLevel) {
        return 10;
    }

    private enum Sign {
        plus, minus
    }
}
