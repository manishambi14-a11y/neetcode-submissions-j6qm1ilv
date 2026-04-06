class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; 
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(c1, c2)) return true;
            c2[s2.charAt(i + s1.length()) - 'a']++;
            c2[s2.charAt(i) - 'a']--;
        }
        return match(c1, c2);
    }
    public boolean match(int[] a, int[] b){
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
