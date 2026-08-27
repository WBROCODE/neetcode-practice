class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

int remove = 0;
int prevEnd = intervals[0][1];

for (int i = 1; i < intervals.length; i++) {
    int start = intervals[i][0];
    int end = intervals[i][1];

    if (start < prevEnd) {
        // overlap
        remove++;

        // 保留结束更早的区间
        prevEnd = Math.min(prevEnd, end);
    } else {
        prevEnd = end;
    }
}

return remove;
    }
}
