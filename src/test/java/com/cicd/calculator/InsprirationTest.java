package com.cicd.calculator;

import com.cicd.calculator.domain.Inspriration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsprirationTest {

    static Inspriration inspriration;

    @BeforeAll
    static void setUp() {
        inspriration = new Inspriration();
    }

    @RepeatedTest(10)
    void quote() {
        String quote = inspriration.Quote();
        assertAll(() -> assertNotNull(quote),
                () -> assertFalse(quote.isEmpty()));
    }

    @Test
    void updateAndGetCallCounter() {
        inspriration.Quote();
        int firstCallCounter = inspriration.getCallCounter();
        assertTrue(firstCallCounter >= 0);
        inspriration.Quote();
        assertTrue(inspriration.getCallCounter() > firstCallCounter);
    }
}