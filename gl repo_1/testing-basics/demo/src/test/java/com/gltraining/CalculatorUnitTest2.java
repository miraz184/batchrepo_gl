package com.gltraining;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CalculatorUnitTest2 {

    @Mock
    Adder adder;

    @InjectMocks
    @Spy
    Calculator calcy;


    @BeforeEach
    public void setup(){

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