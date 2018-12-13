package com.UmmuLearns.poocha;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Given a string expression with parenthesis, evaluate it.
 */
public class ExpressionEvaluator {

    final String expr;

    enum Operator {
        UNKNOWN(0, null),
        PLUS(2, (a,b) -> a+b),
        MINUS(2, (a,b) -> a-b),
        PRODUCT(2, (a,b) -> a*b),
        DIVISION(2, (a,b) -> a/b),
        MODULO(2, (a,b) -> a%b),
        PARENTHESIS(0, null);

        /**
         * Track the number of operands to pop out of the stack for evaluating
         * the operation.
         * NOTE: An alternative would be to track if this is a binary operator or not.
         * I don't think we'd be supporting ternary operators at all.
         */
        final int operands;

        final BiFunction<Integer, Integer, Integer> operation;

        Operator(final int operands, BiFunction<Integer, Integer, Integer> operation) {
            this.operands = operands;
            this.operation  = operation;
        }

        public static Operator forChar(final char ch) {

            switch (ch) {
                case '+':
                    return PLUS;
                case '-':
                    return MINUS;
                case '*':
                    return PRODUCT;
                case '/':
                    return DIVISION;
                case '%':
                    return MODULO;
                case '(':
                    return PARENTHESIS;
                 default:
                    return UNKNOWN;
            }
        }

    }

    public ExpressionEvaluator(final String expr) {
        // Constructor
        this.expr = expr;
        System.out.println("Expr: " + expr);
    }

    Stack<Operator> operator = new Stack<>();
    Stack<Integer> values = new Stack<>();

    /**
     * Pop operators till you get a parenthesis or end of operators.
     * Pop operands from the values stack, and push the result once evaluation is done.
     */
    private void evalOp(boolean isSubExpr) {
        boolean isEvalStarted = false;
        Operator terminator = isSubExpr?Operator.PARENTHESIS: null;
        while (operator.peek() != terminator) {
            doSingleEval();
            isEvalStarted = true;
        }

        if (isSubExpr) {
            if (!isEvalStarted) throw new RuntimeException("Insufficient operators to pop.");

            if (operator.pop() != Operator.PARENTHESIS) {
                // Should never reach here
                throw new RuntimeException("Evaluated a subexpr, but could not find closing parenthesis.");
            }

        }

        if (operator.empty()) {
            if (values.size() == 1) {
                // Evaluation complete, do nothing.
                return;
            }
        }

        while(operator.peek() == null) {
            doSingleEval();
        }
    }

    private void doSingleEval() {
        Operator op = operator.pop();
        Integer op2 = values.pop();
        Integer op1 = values.pop();
        if (op == null) {
            throw new RuntimeException("Insufficient operators to apply");
        }
        if (op1 == null || op2 == null) {
            throw new RuntimeException("Insufficient operands for : " + op.toString());
        }
        values.push(op.operation.apply(op1, op2));
    }

    /**
     * Evaluates the expr and prints out the evaluated result
     */
    public void evaluate() {
        // Edge cases
        if (null == expr || expr.length() == 0) {
            // Parse fail, throw exception?
            throw new RuntimeException("Invalid expression.");
        }

        final int len = expr.length();
        for (int i = 0; i < len; i++ ) {
            char bit = expr.charAt(i);

            // End
            if (bit == '\0') {
                evalOp(false);
                break;
            }

            // Subexpression
            if (bit == ')') {
                evalOp(true); // pops the topmost operator, and operands for it.
                continue;
            }

            // If next token is a number, push that to values stack
            if (bit >= '0' && bit <= '9') {
                String number = "" + bit;

                if(i != len -1) {
                    char nextBit = expr.charAt(i+1);
                    while (nextBit != '\0' && nextBit >= '0' && nextBit <= '9' ) {
                        number += nextBit;
                        nextBit = expr.charAt(++i);
                    }
                }

                values.push(Integer.parseInt(number));
                continue;
            }

            // This better be an operator, if not, its an exception.
            operator.push(Operator.forChar(bit));
        }

        // At this point, you should have popped all your operands, else its an invalid
        // expression

        if (operator.empty()) {
            if(values.size() == 1) {
                System.out.println("Result: " + values.pop());
                return;
            }
        }

        // FATAL
        throw new RuntimeException("Invalid expression.");
    }

    public static void main(String[] args) {
        new ExpressionEvaluator("(((1+2)+5)-(3*2))").evaluate();
        new ExpressionEvaluator("(((1+2)+5)/2)").evaluate();
        new ExpressionEvaluator("(((1+2)+5)%3)").evaluate();
        new ExpressionEvaluator("(10)").evaluate();
    }
}
