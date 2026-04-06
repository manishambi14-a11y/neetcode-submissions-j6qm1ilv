class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
            );

        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];
            pq.offer(new double[]{position[i], time});
        }

        int fleet = 0;
        double prevTime = 0;

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double currTime = curr[1];

            if (currTime > prevTime) {
                fleet++;
                prevTime = currTime;
            }
        }

        return fleet;
    }
}
