class KthLargest {
    int largestReq;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        largestReq = k;
        pq = new PriorityQueue<Integer>();
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > largestReq) {
            pq.poll();
        }
        return pq.peek();
    }
}
