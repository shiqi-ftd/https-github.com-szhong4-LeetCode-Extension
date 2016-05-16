public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 1, index3 = 1, index5 = 1;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2,factor3),factor5);
            res[i] = min;
            if(factor2 == min)
                factor2 = 2 * res[index2++];
            if(factor3 == min)
                factor3 = 3 * res[index3++];
            if(factor5 == min)
                factor5 = 5 * res[index5++];
        }
        
        return res[n - 1];
    }
}