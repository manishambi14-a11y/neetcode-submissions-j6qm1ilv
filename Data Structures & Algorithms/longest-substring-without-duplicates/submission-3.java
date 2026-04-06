class Solution {
    public int lengthOfLongestSubstring(String s) {
        //zxyuzouxzo
        HashSet<Character> set = new HashSet<>();
        if (s.length() == 0) return 0; 
        int i = 0, j = 0;
        int dist = 0;
        boolean flag = false;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                dist = Math.max(dist, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return dist;
    }
}
