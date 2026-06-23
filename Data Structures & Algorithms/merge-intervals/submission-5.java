class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        ans.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int lastS = ans.get(ans.size() - 1)[0];
            int lastE = ans.get(ans.size() - 1)[1];
            int curS = intervals[i][0];
            int curE = intervals[i][1];

            if(lastE >= curS){
                ans.get(ans.size() - 1)[1] =  Math.max(lastE, curE);
            }else if(curS > lastE){
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
