package Easy.LongestCommonPrefix;

public class Solution {
    // NeetCode explanation
    // https://youtu.be/0sWShKIJoo4?si=dZZWtA2dHCy4JEpK

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        /*
         * This problem requires O(m*n) time where m is the average size of a string and n is the number of strings.
         * You start with one string from the array. Then you keep comparing the characters of that string,
         * against the other strings in the array. The soonest you find a mismatch, you return the current result.
         * Or if you reach the end of current string, whichever that might be, that means we have gone through the
         * shortest string in the array, and we don't need to check any other strings.
         * */

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }

            result.append(c);
        }

        return result.toString();
    }
}
