package Easy.MajorityElement;

class Solution {
    // NeetCode explanation
    // https://youtu.be/7pnhv842keE?si=aS5fExbNh9fkksks

    public static void main(String[] args) {
        Solution s = new Solution();
        s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
//        s.majorityElement(new int[]{3, 2, 3});
    }

    public int majorityElement(int[] nums) {
        // You can always use a HashMap to keep the count but that would require extra O(n) space

        // to solve this in O(1) space and O(n) time, Since the problem states that there will always
        // be a majority element i.e. no 2 elements with the same highest count, we can use
        // the Boyer–Moore algorithm https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
        // it works like this

        // you initially consider some element in the nums array to be the majority element
        // you iterate from left to right, and everytime you come across that element, you increment a counter by 1
        // when you come across a different element, you decrement the counter by 1
        // if the counter becomes 0, that means we have seen the same number of elements of 2 different elements
        // that means considering what we have seen so far in the array, no elements are candidates for majority

        // when the counter hits 0, we consider the next element in the array as the majority
        // and we keep doing this until we reach the end of the array
        // since the problem states that there will always be a majority,
        // when we come to the end of the array, counter must be greater than 0, and whatever value
        // we considered to be the result, is the actual majority

        // the gotcha is, the majority element occurs more frequently than the rest of the array combined!

        int res = nums[0];
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                res = nums[i];
            }

            if (nums[i] == res) {
                counter++;
            } else {
                counter--;
            }

        }

        // to see the final result
        System.out.println(res);

        return res;
    }
}