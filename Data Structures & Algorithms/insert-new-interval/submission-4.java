class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> temp = new ArrayList<>();
         for(int[] interval : intervals){
            temp.add(interval);
         }
         temp.add(newInterval);
         List<int[]> ans = new ArrayList<>();
         Collections.sort(temp, (a,b)->a[0] - b[0]);
         
         ans.add(temp.get(0));
         for(int i = 1; i < temp.size(); i++){
            int[] last = temp.get(ans.size() - 1);
            int[] cur = temp.get(i);
            int lastS = last[0], lastE = last[1], curS = cur[0], curE = cur[1];
            if(curS <= lastE){
               last[1] = Math.max(curE, lastE);
            }else if(curS > lastE){
               ans.add(cur);
            }
         }

         int size = ans.size();

         int[][] res = new int[size][2];
         for(int i = 0; i < size; i++){
            res[i] = ans.get(i);
         }

         return res;
         /**
         
         
                     LE
            lS
               CS    
         */
    }
}
