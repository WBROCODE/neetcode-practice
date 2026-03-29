class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> ans = new ArrayList<>();
         Arrays.sort(intervals, (a,b)->a[0] - b[0]);
         int n = intervals.length;
         int i = 0;
         int newS = newInterval[0], newE = newInterval[1];
         while(i < n && intervals[i][1] < newS){
            ans.add(intervals[i]);
            i++;
         }

         while(i < n && intervals[i][0] <= newE){
            newS = Math.min(intervals[i][0], newS);
            newE = Math.max(intervals[i][1], newE);
            i++;
         }
         ans.add(new int[]{newS, newE});
         while(i < n && intervals[i][0] > newE){
            ans.add(intervals[i]);
            i++;
         }
         return ans.toArray(new int[ans.size()][2]);
    }
}
