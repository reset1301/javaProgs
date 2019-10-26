package ru.rrr.handler;

import ru.rrr.enums.Level;

public interface Handler {
    String getExample(int maxCount);

    int getCount(Level difficultLevel);
}
