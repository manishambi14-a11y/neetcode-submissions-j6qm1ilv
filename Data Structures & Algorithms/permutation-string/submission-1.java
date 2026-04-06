class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int l = 0;//0
        int r = s1.length()-1;//2
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (r < s2.length()) {
            String s = s2.substring(l, r+1);
            boolean flag = true;
            tempMap.clear();
            tempMap.putAll(map);
            for (int i = 0; i < s.length(); i++) {
                if (tempMap.containsKey(s.charAt(i)) && tempMap.get(s.charAt(i)) > 0) {
                    tempMap.put(s.charAt(i), tempMap.get(s.charAt(i))-1);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int v : tempMap.values()) {
                    if (v != 0) {
                        flag = false;
                        break;
                    }
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
