class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            p.add(s);
        }
        while (p.size() > 1) {
            int f = p.poll();
            int s = 0;
            if (p.size() > 0) {
                s = p.poll();
            } else {
                return f;
            }
            int r = f - s;
            p.add(r);
        }
        return p.peek();
    }
}
