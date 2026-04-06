class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String ct = new String(c);
            if (!map.containsKey(ct)) {
                map.put(ct,new ArrayList<String>());
            }
            map.get(ct).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
