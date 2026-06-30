package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddition() {

        Calculator calculator = new Calculator();

        assertEquals(10, calculator.add(5,5));
    }
}