class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->(a[0] - b[0]));

        ans.add(intervals[0]);

        for(int i = 1; i < n; i++){
            int[] last = ans.get(ans.size() - 1);
            int[] cur = intervals[i];
            int lastS = last[0], lastE = last[1], curS = cur[0], curE = cur[1];
            if(lastE >= curS){
                last[1] = Math.max(curE, lastE);
            }else if(curS > lastE){
                ans.add(cur);
            }
        }
        /**
        
                LS          LE
                        CS          CE
        */
        int size = ans.size();
        int[][]res = new int[size][2];
        for(int i = 0; i < size; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
