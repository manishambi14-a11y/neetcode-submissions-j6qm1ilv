class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;  i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            p.add(new int[]{e.getKey(), e.getValue()});//[1,1] [2,2] [3,3]
            if (p.size() > k) {
                p.poll();
            }
        }
        int res[] = new int[k];
        int j = 0;
        while (k > 0) {
            int[] temp = p.poll(); // [x,y]
            res[j++] = temp[0];
            k--;
        }
        return res;
    }
}
