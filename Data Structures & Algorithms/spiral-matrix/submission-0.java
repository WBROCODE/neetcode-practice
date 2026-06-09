class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int up = 0, down = m - 1, left = 0, right = n - 1;

        while(ans.size() < m * n){
            // move right
            for(int j = left; j <= right && ans.size() < m * n; j++){
                ans.add(matrix[up][j]);
            }
            up++;
            // move down
            for(int i = up; i <= down && ans.size() < m * n; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            // move left
            for(int j = right; j >= left && ans.size() < m * n; j--){
                ans.add(matrix[down][j]);
            }
            down--;
            // move up
            for(int i = down; i >= up && ans.size() < m * n; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;
    }
}
