package Easy.IsomorphicStrings;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "add"));
//        System.out.println(s.isIsomorphic("foo", "bar"));
//        System.out.println(s.isIsomorphic("paper", "title"));
//        System.out.println(s.isIsomorphic("badc", "baba"));
    }

    // a much faster int[] based solution
    public boolean isIsomorphic(String s, String t) {
        // since the problem states that no two characters may map to the same character,
        // mapping has to work both ways. i.e. g(a) -> b && f(b) -> a for all a and b

        int[] map1 = new int[128];
        int[] map2 = new int[128];

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (map1[ss[i]] != 0 && map1[ss[i]] != tt[i] ||
                    map2[tt[i]] != 0 && map2[tt[i]] != ss[i]) {
                return false;
            }

            map1[ss[i]] = tt[i];
            map2[tt[i]] = ss[i];
        }

        return true;
    }

    // a hashmap based solution

//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map1 = new HashMap<>();
//        Map<Character, Character> map2 = new HashMap<>();
//
//        char[] ss = s.toCharArray();
//        char[] tt = t.toCharArray();
//
//        for (int i = 0; i < ss.length; i++) {
//            if (map1.containsKey(ss[i]) && map1.get(ss[i]) != tt[i] ||
//                    map2.containsKey(tt[i]) && map2.get(tt[i]) != ss[i]) {
//                return false;
//            }
//
//            map1.put(ss[i], tt[i]);
//            map2.put(tt[i], ss[i]);
//        }
//
//        return true;
//    }
}
