package Easy.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // NeetCode explanation
    // https://youtu.be/3jdxYj3DD98?si=nlrlNRb7gxYaPwYi
    public static void main(String[] args) {
        Solution s = new Solution();

        // System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("MCMXCIV"));
    }


    /*

    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    */

    private static final Map<Character, Integer> map = new HashMap<>();

    static {
        // values populated here so the runtime does not count time spent to put values

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        /*
         * In roman numbers, digits are always in the decreasing order.
         * If for some reason, 2 consecutive characters are in the increasing order, that means the 1st character is
         * a modifier for the 2nd character. eg: CM means -100 + 1000
         * so if come across a modifier, we subtract its value from the sum
         * in all the other cases, we will be adding the corresponding integer to the sum
         * */

        int num = 0;

        for (int l = 0; l < s.length(); l++) {
            int current = map.get(s.charAt(l));
            if (l + 1 < s.length() && current < map.get(s.charAt(l + 1))) {
                // this means the current character is a modifier for the next character
                num -= current;
            } else {
                num += current;
            }
        }

        return num;
    }

}
