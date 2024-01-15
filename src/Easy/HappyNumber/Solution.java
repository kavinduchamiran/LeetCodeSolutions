package Easy.HappyNumber;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(2));
    }


    public boolean isHappy(int n) {
        int sum = 0;

        // this does the digit-wise multiplication and addition
        while (n > 0) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }

        if (sum == 1) {
            return true;
        } else if (sum == 4) {
            // if sum ever be 4, you will end up in a loop. you can start from 2 and keep going to witness this.
            return false;
        }

        return isHappy(sum);
    }


    // HashMap based solution, takes more time though
    /*
    Map<Integer, Integer> map = new HashMap<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int m = reduce(n);

        if (map.containsKey(m))
            return false;

        map.put(n, m);

        return isHappy(m);
    }

    private int reduce(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int sum = 0;

        while (n > 0) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }

        return sum;
    }
*/
}
