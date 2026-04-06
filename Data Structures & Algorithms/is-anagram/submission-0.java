class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        } // map = j 1 a 1 r 1 
        for (int i = 0 ; i < t.length(); i++) { // j a m
            if (map.containsKey(t.charAt(i))) {
                int val = map.get(t.charAt(i));
                if (val == 0) return false;
                map.put(t.charAt(i), val-1);  
            } else {
                return false;
            }
        }
        return true;
    }
}
