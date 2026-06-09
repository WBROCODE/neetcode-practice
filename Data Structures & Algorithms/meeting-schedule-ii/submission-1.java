class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> rooms = new ArrayList<>();

        for(Interval interval : intervals){
            int start = interval.start;
            int end = interval.end;

            rooms.add(new int[]{start, +1});
            rooms.add(new int[]{end, -1});
        }

        Collections.sort(rooms, (a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });


        int cur = 0;
        int ans = 0;

        for(int[] room : rooms){
            cur += room[1];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}