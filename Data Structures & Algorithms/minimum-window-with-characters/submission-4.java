class Solution {
    public String minWindow(String s, String t) {

        String oS = s;

        if (s.length() < t.length()) return "";

        int l = 0, r = t.length() - 1;
        int len = 10001;
        String res = "";

        while (r < s.length()) {

            String temp = s.substring(l, r + 1);

            if (isMatch(temp, t)) {

                int newL = l + shrink(temp, t);

                if (len > (r - newL + 1)) {
                    len = r - newL + 1;
                    res = oS.substring(newL, r + 1);
                }

                l = newL;
            }

            r++;
        }

        return res;
    }

    public boolean isMatch(String s, String t) {

        int[] storeT = new int[128];
        int[] storeS = new int[128];

        for (int i = 0; i < t.length(); i++) {
            storeT[t.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            storeS[s.charAt(i)]++;
        }

        for (int i = 0; i < 128; i++) {
            if (storeT[i] > storeS[i]) return false;
        }

        return true;
    }

    public int shrink(String s, String t) {

        int i = 0;

        while (i < s.length()) {

            if (isMatch(s.substring(i + 1), t)) {
                i++;
            } else {
                return i;
            }
        }

        return i;
    }
}
