package Easy.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));

    }

    public int[] twoSum(int[] nums, int target) {
        // when we iterate through the nums[], we need a quick way to determine if target - nums[i] is in the nums[].
        // array lookups are O(n) so you can use a HashMap instead.
        // here, we are storing the value we need (diff), and its index.
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            // if nums[i] already exists, in another iteration, target - nums[i] has been put into the array.
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);

                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
}
