class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a,b)->a[1] - b[1]);
        int prevE = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int curE = intervals[i][1];
            int curS = intervals[i][0];
            if(curS < prevE){
                ans++;
            }else{
                prevE = curE;
            }
        }
        return ans;
    }
}
