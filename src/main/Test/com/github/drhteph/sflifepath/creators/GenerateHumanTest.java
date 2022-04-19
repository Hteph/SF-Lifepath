package com.github.drhteph.sflifepath.creators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateHumanTest {
    
    @Test
    void getRandomHuman() {
        
        var testPerson = GenerateHuman.getRandomHuman();
        
        assertNotNull(testPerson);
        
    }
    
    @Test
    void generateMainHumanCharacter() {
    
        var testPerson = GenerateHuman.generateMainHumanCharacter();
        
        assertNotNull(testPerson);
        
    }
}