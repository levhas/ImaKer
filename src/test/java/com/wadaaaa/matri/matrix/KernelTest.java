package com.wadaaaa.matri.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KernelTest {
    Kernel testKernel;
    @BeforeEach
    void setup(){
        testKernel = new Kernel(new float[]{1, 1, -1, 2, 2, 2, 1, 1, 1});
    }

    @Test
    void testKernelify() {
        int[] testData = new int[9];
        Arrays.fill(testData, 1);
        var test = testKernel.kernelify(testData);
        var expectedColor = new Color(0,0,10);
        assertEquals(expectedColor,test);
    }

    @Test
    void testBiggerKernel(){
        testKernel.setValues(new float[]{4,3,2,1,0,
                                        3,2,1,0,-1,
                                        2,1,0,-1,-2,
                                        1,0,-1,-2,-3,
                                        0,-1,-2,-3,-4});
        int[] testData = new int[25];
        Arrays.fill(testData, 1);
        var result = testKernel.kernelify(testData);
        assertEquals(new Color(0,0,0), result);
    }
}