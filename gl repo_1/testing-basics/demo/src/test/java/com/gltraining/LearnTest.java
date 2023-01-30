package com.gltraining;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class LearnTest {

    @Test
    public void test1(){
        List<Integer> list= Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn(10);
        Mockito.when(list.get(1)).thenReturn(20);

        //using
        int val1=list.get(0);
        int val2=list.get(1);
        System.out.println("val1="+val1+" ,val2="+val2);
    }
}
