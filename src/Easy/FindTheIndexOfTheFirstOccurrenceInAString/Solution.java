package Easy.FindTheIndexOfTheFirstOccurrenceInAString;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.strStr("sadbutsad", "sad"));
//        System.out.println(s.strStr("leetcode", "leeto"));
//        System.out.println(s.strStr("hello", "ll"));
//        System.out.println(s.strStr("mississippi", "issip"));
        System.out.println(s.strStr("aabaaabaab", "aabaab"));

    }

    // the built in String.indexOf() function totally works, and you can get 100% score.
    // if you are feeling a little bit adventurous, you can try implementing it by hand

//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }

    public int strStr(String haystack, String needle) {

        // empty strings are considered to start at the 0th index of haystack
        if (needle.isEmpty()) {
            return 0;
        }

        // we start with 2 pointers, both at the start of the haystack
        int l = 0;
        int r = 0;

        while (r < haystack.length()) {
            // we move l and r to the right until we find the first occurrence of needle[0] in the haystack
            if (haystack.charAt(l) != needle.charAt(0)) {
                l++;
                r = l;
                continue;
            }

            // once we have a matching first character, we move r to the right, until we go through all characters
            // in the needle.

            if (haystack.charAt(r) == needle.charAt(r - l)) {
                r++;
            } else {
                l++;
                r = l;
                continue;
            }

            // once we have gone through the needle, and if all above conditions are satisfied, we return the left
            // pointer as the answer.
            if (r - l == needle.length())
                return l;
        }

        return -1;
    }


}
