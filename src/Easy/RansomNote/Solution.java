package Easy.RansomNote;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canConstruct("a", "b"));
        System.out.println(s.canConstruct("aa", "ab"));
        System.out.println(s.canConstruct("aa", "aab"));

    }

    // a much faster solution using an int array
    // since the problem states that both ransomNote and magazine only consists of small characters,
    // we can put the character count in the ith position where i = ascii(character) - 97 (ascii of 'a')
    // so 'a' will be at 0, 'b' will be at 1, etc.

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] array = new int[26];

        // we do 2 passes, first time counting up
        for (char c : magazine.toCharArray()) {
            array[c - 97] += 1;
        }

        // second time, counting down
        for (char c : ransomNote.toCharArray()) {
            // the first time we run out of characters for any letter, we return false
            if (array[c - 97] == 0) {
                return false;
            }

            array[c - 97] -= 1;
        }

        return true;
    }


//    public boolean canConstruct(String ransomNote, String magazine) {
//        // hashmap based solution
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char c : magazine.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : ransomNote.toCharArray()) {
//            if (!map.containsKey(c)) {
//                return false;
//            }
//
//            int remainder = map.get(c);
//
//            if (remainder <= 0) {
//                return false;
//            }
//
//            map.put(c, remainder - 1);
//        }
//
//        return true;
//    }
}
