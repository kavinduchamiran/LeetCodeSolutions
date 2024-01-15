package Easy.RemoveDuplicatesFromSortedArray;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    public int removeDuplicates(int[] nums) {
        // This problem is similar to the RemoveElement problem
        // instead of the 'val' variable, we have to compare the current element with the last read element
        // last read element will not change until we come across a different value in the sorted array
        // initialing to -101 because the constraints say -100 <= nums[i] <= 100

        int k = 0;
        int lastElement = -101;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastElement) {
                nums[k] = nums[i];
                k++;

                lastElement = nums[i];
            }
        }

        // to see the final nums array
        // System.out.println(Arrays.toString(nums));

        return k;

    }
}
