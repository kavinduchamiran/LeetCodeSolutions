package Easy.MergeSortedArray;

import java.util.Arrays;

class Solution {
    // NeetCode explanation
    // https://youtu.be/P1Ic85RarKY?si=fIx-usx2Wdy4UWYQ

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        s.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // since nums1 already has enough space to fill both nums1 and nums2, we would not need a 3rd array
        // we will start from the end of nums1 and keep filling it from right to left
        // at each iteration, we will compare nums1[m] with nums2[n]
        // and replace nums1[last] with whichever is the bigger value
        // each iteration, we move 'last' to left by 1
        // if we consumed nums1[m], we move m to left by 1
        // if we consumed nums2[n], we move n to left by 1

        // I'm aware that this code could be simplified, but I'm leaving it as it is for clarity

        int last = m + n - 1;
        m--;
        n--;

        while (m > -1 && n > -1) {
            if (nums2[n] > nums1[m]) {
                nums1[last] = nums2[n];
                last--;
                n--;
            } else if (nums2[n] == nums1[m]) {
                nums1[last] = nums1[m];
                last--;
                m--;
            } else if (nums2[n] < nums1[m]) {
                nums1[last] = nums1[m];
                last--;
                m--;
            }
        }

        // once we went through the elements in nums1, and if there are any leftover elements in nums2
        // such that nums2[n] is lesser than nums1's lowest element'
        // we need to prepend all those to the left of nums1's lowest element

        while (n > -1) {
            nums1[last] = nums2[n];
            last--;
            n--;
        }

        // to see the final nums1 array
        System.out.println(Arrays.toString(nums1));
    }
}