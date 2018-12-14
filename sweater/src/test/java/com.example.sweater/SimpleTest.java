package com.example.sweater;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void test() {
        int x = 2;
        int y = 5;
        Assert.assertEquals(7, x + y);
    }
}
