package Easy.IsSubsequence;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
        System.out.println(s.isSubsequence("b", "abc"));
        System.out.println(s.isSubsequence("", "abc"));

    }

    public boolean isSubsequence(String s, String t) {
        // we initialize 2 pointers, sp at the start of s, tp at the start of t
        // we increment sp everytime we come across the same character in t
        // we always increment t, until it reaches the end


        int sp = 0;
        int tp = 0;

        while (sp < s.length()) {
            // if we could not find an answer before tp reached the end, return false
            if (tp == t.length())
                return false;

            // for some weird reason, using a character array here would give you
            // better performance but consumes more memory
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }

            tp++;
        }

        // if we manage to get through all characters in s, before t ended, we return true
        return true;

    }
}
