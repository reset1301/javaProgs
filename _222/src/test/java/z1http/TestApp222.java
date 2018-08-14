package z1http;

import junit.framework.Assert;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class TestApp222 {
    @Test(expected = NullPointerException.class)
    public void testApp() {
        String expected = "333";
        String actual = "333";
        int i = Integer.parseInt("10");

        Assert.assertEquals(expected, actual);
        throw new NullPointerException();

    }
}
