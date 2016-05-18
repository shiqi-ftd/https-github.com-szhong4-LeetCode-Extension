public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i <= len; i++) {
            int cur = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] < nums[i - 1]) {
                    cur = Math.max(dp[j] + 1, cur);
                }
                dp[i] = cur;
                max = Math.max(1, dp[i]);
            }
        }
        return max;
    }
}