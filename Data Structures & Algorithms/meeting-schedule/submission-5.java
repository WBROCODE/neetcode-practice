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
        if(intervals.isEmpty()) return true;
        Collections.sort(intervals, (a,b)->a.start - b.start);
        
        int prevS = intervals.get(0).start;
        int prevE = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++){
            int curS = intervals.get(i).start;
            int curE = intervals.get(i).end;        
            if(prevE > curS) return false;
            prevS = curS;
            prevE = curE;
        }
        return true;
    }
}
