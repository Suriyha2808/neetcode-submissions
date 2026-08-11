class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Edge case checks
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) {
            return 0;
        }

        int subsetSum = (target + totalSum) / 2;

        // 1D DP Array
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // Base case: 1 way to get sum 0

        for (int num : nums) {
            // Reverse iteration to prevent reusing the same element
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}