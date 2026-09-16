class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        ArrayList<Integer> r = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            r.add(pq.remove()[0]);
            k--;
        }
        int[] re = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            re[i] = r.get(i);
        }
        return re;
    }
}
