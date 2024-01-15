package Easy.ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                int indexDiff = i > index ? i - index : index - i;

                if (indexDiff <= k) {
                    return false;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
