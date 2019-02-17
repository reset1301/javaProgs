package com.example.sweater;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;

public class DumbPasswordEncoderTest {

    @Test
    public void encode() throws ScriptException {
        DumbPasswordEncoder encoder = new DumbPasswordEncoder();
        Assert.assertEquals("secret: 'myPwd'", encoder.encode("myPwd"));
        Assert.assertThat(encoder.encode("myPwd"), containsString("myPwd"));
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
//        System.out.println(engine.eval("a=1;b=2;a+b"));
    }

    @Test(expected = ArithmeticException.class)
    public void exceptionTest() {
        int x = 0;
        int i = 10 / x;
    }

}