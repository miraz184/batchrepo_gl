package com.gltraining;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CalculatorUnitTest1 {

    Calculator calcy;
    Adder adder;

    @BeforeEach
    public void setup(){
        adder= mock(Adder.class);
        Calculator real = new Calculator(adder);
        calcy=spy(real);
    }


    /**
     * scenario: both numbers are positive
     * inputs: 1, 2
     * expected result: 3
     */
    @Test
    public void testAdd_1() {
        when(adder.sum(1,2)).thenReturn(3);
        int result = calcy.add(1, 2);
        int expected=3;
        assertEquals(expected, result);
        verify(adder).sum(1,2);
    }


    /**
     * scenario: both numbers are negative
     * inputs: -2, -5
     * expected result: -7
     */
    @Test
    public void testAdd_2() {
        when(adder.sum(-2,-5)).thenReturn(-7);
        int result = calcy.add(-2, -5);
        int expected=-7;
        assertEquals(expected, result);
        verify(adder).sum(-2,-5);
    }

    /**
     * scenario: postive number passed
     * input: 5
     * expected result:15
     */
    @Test
    public void testAdBy10_1(){
        doReturn(15).when(calcy).add(5,10);
        int result=calcy.addBy10(5);
        int expected=15;
        assertEquals(expected,result);
        verify(calcy).add(5,10);
    }


}