package Easy.WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
//        System.out.println(s.wordPattern("abba", "dog cat cat fish"));
//        System.out.println(s.wordPattern("aaaa", "dog cat cat dog"));
//        System.out.println(s.wordPattern("abba", "dog dog dog dog"));
        System.out.println(s.wordPattern("a", "a"));
    }


    // this problem is very similar to IsomorphicStrings
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");

        if (chars.length != words.length) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                if (map.containsValue(words[i]))
                    return false;

                map.put(chars[i], words[i]);
            } else {
                if (!map.get(chars[i]).equals(words[i]))
                    return false;
            }
        }

        return true;
    }

}
