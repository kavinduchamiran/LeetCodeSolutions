package Easy.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();

        int l = 0;
        int r = 0;

        while (r < nums.length) {


            if (r + 1 < nums.length && nums[r + 1] - nums[r] == 1) {
                if (r + 1 < nums.length) {
                    r++;
                }
            } else {
                if (nums[l] == nums[r]) {
                    output.add(String.valueOf(nums[l]));
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append(nums[l]);
                    builder.append("->");
                    builder.append(nums[r]);
                    output.add(builder.toString());
                }

                r += 1;
                l = r;
            }
        }


        return output;
    }


}
