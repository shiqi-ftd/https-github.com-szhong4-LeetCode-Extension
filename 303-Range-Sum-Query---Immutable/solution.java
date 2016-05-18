public class NumArray {

    int[] nums;
    int[] dp;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j] - dp[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);