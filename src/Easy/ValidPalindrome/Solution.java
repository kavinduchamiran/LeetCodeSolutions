package Easy.ValidPalindrome;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        // we start with 2 pointers. l from left end, r from right end
        int l = 0;
        int r = s.length() - 1;

        // until the 2 pointers meet in the middle
        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);

            // we want to skip through the invalid characters (spaces, special characters)
            if (!isValid(lc)) {
                l++;
                continue;
            }

            // we want to skip through the invalid characters (spaces, special characters)
            if (!isValid(rc)) {
                r--;
                continue;
            }

            // after skipping through, the new l and r characters does not match, then return false
            if (!doesMatch(lc, rc)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    // 48 = 0, 57 = 10
    // 97 = a, 122 = b
    // 65 = A, 90 = B
    private boolean isValid(char c) {
        return 48 <= c && c <= 57 || 97 <= c && c <= 122 || 65 <= c && c <= 90;
    }

    // either characters match, or they match case-insensitively
    private boolean doesMatch(char a, char b) {
        return a == b || Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
