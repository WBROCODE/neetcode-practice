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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        Collections.sort(intervals, (a,b)->{
            return a.end - b.end;
        });
        int preE = intervals.get(0).end;
        int i = 1;
        int n = intervals.size();
        while(i < n){
            Interval cur = intervals.get(i) ;
            if(preE > cur.start) return false;
            else preE = cur.end;
            i++;
        }

        return true;
    }
}
