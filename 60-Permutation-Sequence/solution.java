public class Solution {
    List<Integer> kth;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(k, 0, new ArrayList<Integer>(), nums);
        StringBuilder sb = new StringBuilder();
        for (int i : kth) {
            sb.append(i);
        }
        return sb.toString();
    }
    public void helper(int end, int counter, ArrayList<Integer> cur, int[] nums) {
        if (counter == end) {
            kth = cur;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            helper(end, counter + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}