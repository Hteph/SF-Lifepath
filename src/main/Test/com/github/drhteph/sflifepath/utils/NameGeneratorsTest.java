package com.github.drhteph.sflifepath.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameGeneratorsTest {
    
    @Test
    void randomName() {
        
        String[] testNames = new String[10];
        
        for (int i=0;i<10;i++){
        
            testNames[i] = NameGenerators.randomName(10);
        }
        
        assertEquals(10,testNames.length);
    }
}