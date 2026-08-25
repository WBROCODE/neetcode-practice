class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        // max heap
        // TC: N * logK, SC: K
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        );

        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] ans = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }
        return ans;
    }
}
