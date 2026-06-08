class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        ans.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] last = ans.get(ans.size() - 1);
            int lastS = last[0], lastE = last[1];

            int[] current = intervals[i];
            int newS = current[0], newE = current[1];

            if(lastE < newS){
                ans.add(current);
            }else if(newS <= lastE){
                ans.get(ans.size() - 1)[1] = Math.max(lastE, newE);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
