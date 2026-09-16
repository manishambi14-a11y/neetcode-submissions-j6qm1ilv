class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> map = new HashMap<>();
        
        for (String ele : strs){
            long [] h = new long[26];
            for(int i =0; i<ele.length(); i++ ){
                h[ele.charAt(i)-'a']++;

            }
            String arr = "";
            for (int i = 0; i < h.length; i++) {
            arr += "#" + h[i];
}
            if(map.containsKey(arr)){
                List<String> j =  map.get(arr);
                j.add(ele);
                map.put(arr, j);
            }else{
                List<String> list = new ArrayList<>();
                list.add(ele);
                map.put(arr, list);
            }
        }
        List<List<String>> value = new ArrayList<>();
        for(Map.Entry<String, List<String>> i : map.entrySet()){
            value.add(i.getValue());
        }

        return value;
    }
}