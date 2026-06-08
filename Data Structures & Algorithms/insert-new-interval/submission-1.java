class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> newIntervals = new ArrayList<>();
         for(int[] interval : intervals){
            newIntervals.add(interval);
         }
         newIntervals.add(newInterval);
         Collections.sort(newIntervals, (a,b)->a[0] - b[0]);
         int n = newIntervals.size();
         List<int[]> ans = new ArrayList<>();
         ans.add(newIntervals.get(0));

         for(int i = 1; i < n; i++){
            int[] last = ans.get(ans.size() - 1);
            int[] current = newIntervals.get(i);

            int lastS = last[0];
            int lastE = last[1];

            int newS = current[0];
            int newE = current[1];

            if(lastE < newS) ans.add(current);
            else if(lastE >= newS){
               last[0] = Math.min(lastS, newS);
               last[1] = Math.max(lastE, newE);
            }
         }

         int[][] res = new int[ans.size()][2];
         int i = 0;
         for(int[] p : ans){
            res[i++] = p;
         }
         return res;
    }
}
