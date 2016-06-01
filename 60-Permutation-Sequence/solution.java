public class Solution {    
    if (n < 1 || n > 9 || k < 1) return "";

    int[] fac = new int[n + 1];
    fac[0] = 1;
    for (int i = 1; i < n; i++) fac[i] = i * fac[i - 1];

    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= n; i++) numbers.add(i);
    
    StringBuilder sb = new StringBuilder();
    k-= 1;
    for (int i = n - 1; i >= 0; i--) {
        int index = k / fac[i];
        sb.append(numbers.remove(index));
        k %= fac[i];
    }
    return sb.toString();
}
