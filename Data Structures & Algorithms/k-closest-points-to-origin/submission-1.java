class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->
            b.distance - a.distance
        );

        for(int[] point : points){
            pq.offer(new Point(point[0], point[1]));
        }

        while(pq.size() > k){
            pq.poll();
        }
        int[][] ans = new int[k][2];
        int index = 0;
        for(Point p : pq){
            int x = p.x;
            int y = p.y;
            ans[index][0] = x;
            ans[index][1] = y;
            index++;
        }

        return ans;
    }
}

class Point{
    int x;
    int y;
    int distance;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        distance = x * x + y * y;
    }
}
