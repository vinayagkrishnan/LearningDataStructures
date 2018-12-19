package com.UmmuLearns.stacksandqueues;

import java.util.Stack;

/**
 * Reverse Polish Notaion (RPN) or postfix notation, is a mathematical notation in which operators follow their operands
 * Eg:- (3+4)*5 is expressed as 3 4 + 5 *
 * Eg:- 2 3 1 * + 9 - evaluates to ((3*1) + 2) - 9 = -4
 * This class evaluates an RPN expression where elements are separated by a comma delimiter
 * Operands must be Integers
 */

public class RPNExpressionEvaluator {

    /**
     * Accepts a String representing an RPN/postfix expression and evaluates it to a single value
     * The string expression may contain any numbers and +,-,* or / operators
     * The expression is scanned from left to right and when an operand is detected, it is pushed onto a stack
     * When an operator is detected, the required operands are taken from the stack to evaluate the sub expression
     * and the intermediate result is stored back into the stack
     *
     * @param expression - RPN expression
     * @return int result of evaluation
     * @throws IllegalArgumentException if expression has invalid tokens
     */
    public int evalExpression(final String expression) {

        final String delimiter = ",";
        String[] expressionElements = expression.split(delimiter);
        Stack<Integer> operandStack = new Stack<>();

        for(String element : expressionElements){
            if(isOperator(element)){
                //element is an operator
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1,operand2,element);
                operandStack.push(result);
            } else if (element.matches("[+-]?[0-9]+")){
                //element is an operand
                operandStack.push(Integer.parseInt(element));
            } else {
                //element is an unsupported operator or invalid token
                System.out.println("Error: Invalid expression at " + element);
                throw new IllegalArgumentException();
            }
        }
        return operandStack.pop();
    }

    /**
     * Performs the operation defined by the 'operator' parameter on the operands
     * @param operand1
     * @param operand2
     * @param operator
     * @throws IllegalArgumentException in case of division by 0
     * @return operand1 ( operator ) operand2
     */
    private int performOperation(int operand1, int operand2, String operator) {
        int result = 0;
        switch (operator){
            case "+" : result = operand1 + operand2;
            break;

            case "-" : result = operand1 - operand2;
            break;

            case "*" : result = operand1 * operand2;
            break;

            case "/" :
                if (operand2 == 0){
                    throw new IllegalArgumentException("Error : Division by zero");
                } else {
                    result = operand1/operand2;
                }
            break;
        }
        return result;
    }

    /**
     * Checks if the given String token represents any of the supported operators (+,-,*,/)
     * @param element
     * @return true/false
     */
    private boolean isOperator(String element){
        return (element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-"));
    }
}
