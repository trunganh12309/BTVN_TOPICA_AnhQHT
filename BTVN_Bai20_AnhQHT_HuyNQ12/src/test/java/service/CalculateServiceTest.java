package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateServiceTest {

    @Test(expected = ArithmeticException.class)
    public void divide() {
        CalculateService calculateService = new CalculateService();
        int result = calculateService.divide(1,0);
//        assertEquals();
    }

    
}