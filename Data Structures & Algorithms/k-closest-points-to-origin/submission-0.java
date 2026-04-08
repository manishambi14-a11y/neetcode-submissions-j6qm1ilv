class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> p = new PriorityQueue<>(
            (a, b) -> Double.compare(a[1], b[1])
        );
        for (int i = 0; i < points.length; i++) {
            double d = Math.sqrt(Math.pow((0 - points[i][0]), 2) + Math.pow((0 - points[i][1]), 2));
            p.add(new double[]{(double)(i), d});
        }
        int[][] res = new int[k][2];
        int j = 0;
        while (p.size() > 0 && j < k) {
            double c = p.poll()[0];
            res[j][0] = points[(int)c][0];
            res[j][1] = points[(int)c][1];
            j++;
        }
        return res;
    }
}
