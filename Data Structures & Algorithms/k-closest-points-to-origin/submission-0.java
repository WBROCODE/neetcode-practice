class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a , b)->{
                int distA = a[0] * a[0] + a[1] * a[1];
                int distB = b[0] * b[0] + b[1] * b[1];
                return distA - distB; 
            }
        );

        for(int[]point : points) pq.offer(point);

        int[][] ans = new int[k][2];
        int i = 0;
        while(k > 0){
            int[] close = pq.poll();
            ans[k-1] = close;
            k--;
        }

        return ans;

    }
}
