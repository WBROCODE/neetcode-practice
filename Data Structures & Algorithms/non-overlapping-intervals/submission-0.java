class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         int ans = 0;
        Arrays.sort(intervals, (a,b)->a[1] - b[1]);
        int n = intervals.length;
        int prevE = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(prevE > intervals[i][0]) ans++;
            else prevE =  intervals[i][1];
        }
        return ans;
    }
}
