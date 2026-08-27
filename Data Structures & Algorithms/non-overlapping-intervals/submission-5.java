class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        /**
                    1   2
                    1       4 

                        2   4
                           
        */
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        int prevE = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int curE = intervals[i][1];
            int curS = intervals[i][0];
            if(prevE > curS){
                ans++;
                prevE = Math.min(prevE, curE);
            }else{
                prevE = curE;
            }
        }
        return ans;
    }
}
