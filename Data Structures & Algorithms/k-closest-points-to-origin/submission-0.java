class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new int[]{dist, points[i][0], points[i][1]});
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            result[i] = new int[]{point[1], point[2]};
        }

        return result;
    }
}
