public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len + 1];
        if (chars[0] == '0') return 0;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            if (chars[i - 2] > '2' || (chars[i - 2] == '2' && chars[i - 1] > '6')) {
                dp[i] = dp[i - 1];
            } else if (chars[i - 1] == '0' && chars[i - 2] < '2') {
                dp[i] = dp[i - 1];
            } else if (chars[i - 1] == '0' && chars[i - 2] > '3') {
                return 0;
            } else if (chars[i - 2] == '1') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (chars[i - 2] == '2' && chars[i - 1] <= '6' && chars[i - 1] > '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len];
    }
}