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
        Collections.sort(intervals, (a,b)->a.start - b.start);

        for(int i = 1; i < intervals.size(); i++){
            int preE = intervals.get(i - 1).end;
            int curS = intervals.get(i).start;
            if(preE > curS) return false;
        }

        return true;

    }
}
