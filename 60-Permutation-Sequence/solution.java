public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList();
        helper(k, res, new ArrayList<Integer>(), nums);
        List<Integer> kth = res.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : kth) {
            sb.append(i);
        }
        return sb.toString();
    }
    public void helper(int end, List<List<Integer>> res, ArrayList<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            helper(end, res, cur, nums);
            cur.remove(cur.size() - 1);
            if (res.size() == end) break;
        }
    }
}