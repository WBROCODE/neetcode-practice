class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        int n = queries.length;
        /**
            1   3
              2 3
                3       7  
                     6

            1 >= S 
            2
            3
            6
            7
            8
            PQ<int[] len, e>
            Q > E pq->poll
            Q * logQ + logN * N, N + Q
        */
        int[][] queriesSort = new int[n][2];

        for(int i = 0; i < n; i++){
            queriesSort[i][0] = queries[i];
            queriesSort[i][1] = i; 
        }
        Arrays.sort(queriesSort, (a,b)->a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[0] - b[0]
        );
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int i = 0;
        for(int[] q : queriesSort){
            int curQ = q[0];
            int qIndex = q[1];
            // bigger than start
            while(i < intervals.length && curQ >= intervals[i][0]){
                int s = intervals[i][0];
                int e = intervals[i][1];
                pq.offer(new int[]{e - s + 1, e});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < curQ){
                pq.poll();
            }
            if(!pq.isEmpty())ans[qIndex] = pq.peek()[0];
        }

        return ans;
    }
}
