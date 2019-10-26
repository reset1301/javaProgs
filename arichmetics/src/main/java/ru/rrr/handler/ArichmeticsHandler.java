package ru.rrr.handler;

public class ArichmeticsHandler {
    public String getExample(int maxCount) {
        String sign = Math.random() > 0.5 ? "plus" : "minus";
        int firstParam = maxCount / 3 + (int) Math.round(Math.random() * 2 * maxCount / 3);
        int secondParam = 1 +
          (sign.equals("plus")
            ? (int) Math.round((maxCount - firstParam) * Math.random())
            : (int) Math.round(firstParam * Math.random()));

        return String.format("%2d", firstParam) +
          (sign.equals("plus") ? " + " : " - ") +
          String.format("%2d", secondParam) + " =";
    }
}
