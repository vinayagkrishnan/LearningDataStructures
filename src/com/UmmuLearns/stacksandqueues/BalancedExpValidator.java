package com.UmmuLearns.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class tests if a string made up of the characters '(',')','[',']','{','}' is well formed
 * The string is well formed/balanced if the different types of brackets match in the correct order
 * Eg:- "[((){})]" and "[()[]{()()}]" are well formed
 * Eg:- "(}" , "[(){]}" are not well formed
 */
public class BalancedExpValidator {

    private Map<Character, Character> bracketPairMapping = new HashMap<>();
    {
        bracketPairMapping.put('(' , ')');
        bracketPairMapping.put('{' , '}');
        bracketPairMapping.put('[' , ']');
    }

    /**
     * Tests the given string for well-formedness
     * Uses a stack to track all open terms as they are encountered.
     * For any closing term in the expression, the topmost open term in stack should match with the closing term
     * No open terms should remain in the stack after scanning the expression in order for it to be well formed
     * Any characters other than (,{,[,],},) are considered illegal and will cause an exception
     *
     * @param expression - expression to be evaluated
     * @return true string is balanced/false if unbalanced
     * @throws IllegalArgumentException if invalid characters are present in expression/if exp is empty
     */
    boolean validateExpression(final String expression){

        if(!isLegal(expression)){
            throw new IllegalArgumentException("Error: Expression contains invalid characters");
        }

        Stack<Character> tokenStack = new Stack<>();        //keeps track of all the open terms

        for(int i = 0; i < expression.length(); i++){
            char token = expression.charAt(i);
            if(isOpeningBracket(token)){
                tokenStack.push(expression.charAt(i));      //open term pushed to stack
            } else {                                        //closing term is tested for match
                if(tokenStack.isEmpty() || !isMatch(tokenStack.pop(), token)){
                    return false;
                }
            }
        }
        return  tokenStack.isEmpty();                       //no remaining open terms in stack
    }

    /**
     * Checks if the given expression is valid or not.
     * A valid expression contains any of (,{ and ] and/or their matching closing terms
     * @param expression - expression to be evaluated
     * @return true/false
     */
    private boolean isLegal(String expression) {
        final String pattern = "[\\[\\{\\(\\)\\}\\]]*";
        return expression.matches(pattern);
    }


    /**
     * Checks if the provided opening and closing terms match with each other
     * @param openBracket
     * @param closingBracket
     * @return true/false
     */
    private boolean isMatch(char openBracket, char closingBracket) {
        return bracketPairMapping.get(openBracket).equals(closingBracket);
    }

    /**
     * Checks if the given character is an opening term or not
     * @param openingBacket
     * @return true/false
     */
    private boolean isOpeningBracket(char openingBacket) {
        return bracketPairMapping.containsKey(openingBacket);
    }

}
