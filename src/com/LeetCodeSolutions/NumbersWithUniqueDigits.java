package com.LeetCodeSolutions;

public class NumbersWithUniqueDigits {
    /**
     * Q357 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     * Example:
     *     Input: 2
     *     Output: 91
     * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
     * excluding 11,22,33,44,55,66,77,88,99
     * @param n
     * @return Number of unique digit numbers in [0, 10^n)
     */
    public int countNumbersWithUniqueDigits(int n) {

        if(n == 0){
            return 1;           // only one possible digit
        }

        int result = 10;    //for when n = 1
        // when n > 1, there are 9 possible digit choices
        // for the Most Significant Digit
        // For each subsequent digits, the number of possible
        // choices are 9,8,7,6----,2,1
        int uniqueChoices = 9;
        int uniqueNDigitNumbers = 9;

        // when n > 10, there are 0 numbers with unique digits for
        // any number with more than 10 digits. So the result remains
        // unchanged
        for( int i = 2; i <= n && uniqueChoices > 0 ; i++){
            uniqueNDigitNumbers *= uniqueChoices;
            result += uniqueNDigitNumbers;
            uniqueChoices--;
        }

        return result;




    }

}
