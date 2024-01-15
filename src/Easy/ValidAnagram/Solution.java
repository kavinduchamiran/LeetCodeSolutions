package Easy.ValidAnagram;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram", "nagaram"));
//        System.out.println(s.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            chars[ss[i] - 97]++;
        }

        for (int i = 0; i < ss.length; i++) {
            chars[tt[i] - 97]--;
        }

        for (int i : chars) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }
}
