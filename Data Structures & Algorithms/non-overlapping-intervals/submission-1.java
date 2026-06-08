class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1] - b[1]);
        int ans = 0;
        int n = intervals.length;
        int i = 1;
        int prevE = intervals[0][1];

        while(i < n){
            int[] cur = intervals[i];
            if(prevE > cur[0]) ans++;
            else prevE = cur[1];
            i++;
        }
        return ans;
    }
}
