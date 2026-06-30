package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        System.out.println("Setup: Creating Calculator object");
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teardown: Test Completed");
        calculator = null;
    }

    @Test
    public void testAddition() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }
}