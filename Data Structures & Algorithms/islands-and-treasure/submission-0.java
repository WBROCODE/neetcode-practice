class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0) queue.offer(new int[]{i ,j});
            }
        }

        while(!queue.isEmpty()){
            
            int[] cur = queue.poll();
            for(int[] dir : dirs){
                int newX = dir[0] + cur[0];
                int newY = dir[1] + cur[1];
                if(newX < 0 || newY < 0 
                || newX >= m || newY >= n 
                || rooms[newX][newY] != Integer.MAX_VALUE
                ) continue;

                
                rooms[newX][newY] = rooms[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{newX, newY});           
            }
            
        }
    }
    int[][] dirs = new int[][]{
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

}
