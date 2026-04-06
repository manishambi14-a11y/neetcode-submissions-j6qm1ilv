class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int l = 0;//0
        int r = s1.length()-1;//2
        char[] c1 = s1.toCharArray();//a b c
        Arrays.sort(c1); // a b c 
        while (r < s2.length()) {
            String s = s2.substring(l, r+1);
            char[] c2 = s.toCharArray();
            Arrays.sort(c2);
            boolean flag = true;
            for (int i = 0; i < c2.length; i++) {
                if (c1[i] != c2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
