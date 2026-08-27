/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        /**
        
                
            List<int[]> rooms 
            0+ 8- 8+
            
            0+ 5+ 10- 15+ 20- 40- 

        */
        List<int[]> rooms = new ArrayList<>();
        for(Interval i : intervals){
            int s = i.start;
            int e = i.end;
            rooms.add(new int[]{s, 1});
            rooms.add(new int[]{e, -1});
        }
        Collections.sort(rooms, (a,b)->{
            if(a[0] == b[0]) return a[1] - b[1]; 
            return a[0] - b[0];
        });
        int ans = 0;
        int cur = 0;
        for(int[] r : rooms){
            cur += r[1];
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
