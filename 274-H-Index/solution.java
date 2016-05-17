public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] index = new int[len];
        for (int i : citations) {
            if (i >= len - 1) {
                index[len - 1]++
            } else {
                index[i]++;
            }
        }
        int cur = 0;
        for (int i = len - 1; i >= 0; i--) {
            cur += index[i];
            if (len - i < cur) return len - i - 1;
        }
        return len;
    }
}