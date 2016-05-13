public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - k - 1; i++) {
            for (int j = 1; j <= k; j++) {
                if (Math.abs(nums[i] - nums[i + j]) <= t) return true;
            }
        }
        return false;
    }
}