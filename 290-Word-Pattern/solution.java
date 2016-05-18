public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        else if (pattern == null || str == null) return false;
        int pLen = pattern.length();
        String[] word = str.split(' ');
        int wLen = word.length;
        if (plen != wlen) return false;
        
        HashMap<Character, String> hm = new HashMap();
        for (int i = 0; i < pLen; i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!hm.get(pattern.charAt(i)).equals(word[i])) return false;
            } else {
                hm.put(pattern.charAt(i), word[i]);
            }
        }
        return true;
    }
}