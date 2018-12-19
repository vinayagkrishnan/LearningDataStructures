package com.UmmuLearns.stacksandqueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BalancedExpValidatorTest {

    @Test
    void validateExpression() {
        BalancedExpValidator validator = new BalancedExpValidator();

        //well - formed exp
        String testString = "[((){})]";
        Assertions.assertTrue(validator.validateExpression(testString));

        //Well - formed exp
        testString = "[()[]{()()}]";
        Assertions.assertTrue(validator.validateExpression(testString));

        //Matching terms out of order
        testString = "[(){]}";
        Assertions.assertFalse(validator.validateExpression(testString));

        //Unpaired closing term >> popping from empty stack
        testString = "[]}";
        Assertions.assertFalse(validator.validateExpression(testString));

        //Only closing terms;
        testString = "]})";
        Assertions.assertFalse(validator.validateExpression(testString));

        //Invalid expression
        final String invalid_testString = "{[/}]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateExpression(invalid_testString));

    }
}