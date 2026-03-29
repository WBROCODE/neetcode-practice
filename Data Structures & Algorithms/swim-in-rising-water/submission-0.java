class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 0}
        };

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        pq.offer(new Node(0, 0, grid[0][0]));

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        while(!pq.isEmpty()){

            Node cur = pq.poll();
            int fromX = cur.i;
            int fromY = cur.j;
            int val = cur.val;
            if(visited[fromX][fromY]) continue;
            visited[fromX][fromY] = true;
            if(fromX == m -1 && fromY == n - 1) return val;
            

            for(int[] dir : dirs){
                int toX = fromX + dir[0];
                int toY = fromY + dir[1];

                if(toX < 0 || toX >= m || toY < 0 || toY >= n) continue;
                int toVal = Math.max(grid[toX][toY], val);

               
                pq.offer(new Node(toX, toY, toVal));
                

            }
        }

        return -1;
    }
}

class Node{
    int i;
    int j;
    int val;

    public Node(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }

}