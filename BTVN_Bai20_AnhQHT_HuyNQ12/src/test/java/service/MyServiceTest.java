package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyServiceTest {

    @Test
    public void calculate() {
        MyService myService = new MyService();
        float[] result = myService.calculate(1,2,1);
        assertArrayEquals(new float[]{(float)-1},result,0);
    }

    @Test
    public void calculate1() {
        MyService myService = new MyService();
        float[] result = myService.calculate(1,2,0);
        assertArrayEquals(new float[]{0,(float)-2},result,0);
    }

    @Test
    public void calculate2() {
        MyService myService = new MyService();
        float[] result = myService.calculate(1,2,4);
        assertArrayEquals(null,result,0);
    }
}