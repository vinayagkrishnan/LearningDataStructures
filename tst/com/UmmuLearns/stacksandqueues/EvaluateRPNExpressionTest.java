package com.UmmuLearns.stacksandqueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EvaluateRPNExpressionTest {

    @Test
    void evalExpression() {

        RPNExpressionEvaluator evaluator = new RPNExpressionEvaluator();

        String RPN_Expression = "15,7,1,1,+,-,/,3,*,2,1,1,+,+,-";
        Assertions.assertEquals(evaluator.evalExpression(RPN_Expression), 5);

        RPN_Expression = "5,1,2,+,4,*,+,3,-";
        Assertions.assertEquals(evaluator.evalExpression(RPN_Expression), 14);

        RPN_Expression = "4,5,7,2,+,-,*,";
        Assertions.assertEquals(evaluator.evalExpression(RPN_Expression), -16);

        // division by zero case
        final String invalid_math_RPN_Expression = "1,2,+,0,/";
        Assertions.assertThrows(IllegalArgumentException.class, () -> evaluator.evalExpression(invalid_math_RPN_Expression));

        // unsupported operator case
        final String invalid_op_RPN_Expression = "1,2,+,3,%";
        Assertions.assertThrows(IllegalArgumentException.class, () -> evaluator.evalExpression(invalid_op_RPN_Expression));

        // invalid operand case
        final String invalid_arg_RPN_Expression = "1,2ab,+,3,%";
        Assertions.assertThrows(IllegalArgumentException.class, () -> evaluator.evalExpression(invalid_arg_RPN_Expression));

    }
}