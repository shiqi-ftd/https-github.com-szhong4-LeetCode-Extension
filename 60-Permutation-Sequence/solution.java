public class Solution {
    List<Integer> kth;
    int counter = 0;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(k, new ArrayList<Integer>(), nums);
        StringBuilder sb = new StringBuilder();
        for (int i : kth) {
            sb.append(i);
        }
        return sb.toString();
    }
    public void helper(int end, ArrayList<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            counter += 1;
            if (counter == end) {
                kth = cur;
            }  
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            helper(end, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}