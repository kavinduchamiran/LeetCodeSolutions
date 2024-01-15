package Easy.RemoveElement;

class Solution {
    // NeetCode solution
    // https://youtu.be/Pcd1ii9P9ZI?si=mlw2PNxGYHCGawzs

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    public int removeElement(int[] nums, int val) {
        // we are going to iterate through the array from left to right
        // we maintain a pointer k, starting from the left end
        // until we come across any values that are not equal to 'val',
        // we keep moving k to the right by 1
        // in every iteration, we will replace nums' kth value with num's ith value
        // meaning, if we ever came across a 'val', we will not move k, but only increment i
        // and next time we come across a value not equal to 'val', we get and put it at the kth position

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        // to see the final nums1 array
        // System.out.println(Arrays.toString(nums));

        return k;
    }
}