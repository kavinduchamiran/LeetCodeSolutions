package Easy.LengthOfLastWord;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.lengthOfLastWord("Hello World"));
//        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(s.lengthOfLastWord("day"));
//        System.out.println(s.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        /*
         * This is a simple 2 pointer problem.
         * You initialize 2 pointers at the right end of the string.
         * You move both pointers to the left until you find the first non-whitespace character.
         * From there, you move only the left pointer to the left until you find the first whitespace character.
         *
         * Finally, you return the difference between left and right.
         * */

        int r = s.length() - 1;
        int l = r;

        while (l >= 0) {
            if (s.charAt(r) == ' ') {
                r--;
                l = r;
                continue;
            }

            if (s.charAt(l) != ' ') {
                l--;
            } else {
                break;
            }
        }

        return r - l;
    }
}
