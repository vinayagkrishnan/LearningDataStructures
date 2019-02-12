package com.LeetCodeSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Q76
 * Sliding window solution
 */
public class SmallestSubstringWithAllChars {

    /**
     * Given a string S and a string T, this function
     * finds the minimum window in S which will contain all the characters in T
     * in complexity O(n).

     * Example:
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"

     * If there is no such window in S that covers all characters in T, returns the empty string "".
     * (Note: If there is such window, you are guaranteed that there will always be only one unique minimum window in S.)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if(s == null || s.length() == 0){
            return "";
        }
        /*
         * Mapping characters in T with their frequencies
         */
        Map<Character, Integer> charFreqInT = new HashMap();
        for(int i = 0; i < t.length(); i++){
            int freq = charFreqInT.getOrDefault(t.charAt(i), 0);
            charFreqInT.put(t.charAt(i), freq+1);
        }

        /*
         * This map keeps track of characters in S that are in T and their frequencies
         * If for any such character, freq in this map < freq in charFreqInT, then current window
         * is not the required substring
         */
        Map<Character, Integer> charFreqInWindow = new HashMap();

        // For a given window, isFreqMatch is updated whenever the characters in T are all
        // covered (in number of occurances as well) in S
        int isFreqMatch = 0, window_left = 0, window_right = 0;
        int requiredFreq = charFreqInT.size();      // # unique characters in T

        // Array keeps track of the smallest length substring range
        int[] smallestWindow = {Integer.MAX_VALUE, window_left, window_right};

        for(int i = 0; i < s.length(); i++){
            // Expanding the window to the right till all characters are covered
            window_right = i;
            char c = s.charAt(i);
            if(charFreqInT.containsKey(c)){
                int freq = charFreqInWindow.getOrDefault(c,0);
                charFreqInWindow.put(c, freq+1);
                if(freq+1 == charFreqInT.get(c).intValue()){
                    isFreqMatch++;
                }
            }

            // Contracting the left of window to get the smallest window with full coverage
            while(isFreqMatch == requiredFreq && window_left <= window_right){
                int current_WindowLength = window_right - window_left + 1 ;
                // save current window(If it is smaller than the smallest yet) before contracting
                if(current_WindowLength < smallestWindow[0]){
                    smallestWindow[0] = current_WindowLength;
                    smallestWindow[1] = window_left;
                    smallestWindow[2] = window_right;
                }

                char c_left = s.charAt(window_left);

                if(charFreqInT.containsKey(c_left)){
                    // removing the character in the left from the window
                    charFreqInWindow.put(c_left, charFreqInWindow.get(c_left).intValue()-1);
                    if(charFreqInT.get(c_left).intValue() > charFreqInWindow.get(c_left).intValue()){
                        isFreqMatch--;
                    }
                }
                window_left++;
            }
        }

        return smallestWindow[0] < Integer.MAX_VALUE ?
                s.substring(smallestWindow[1], smallestWindow[2] + 1) : "";


    }
}
