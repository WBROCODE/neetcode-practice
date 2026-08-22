class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;


        while(l <= r){
            int mid = l + (r - l) / 2;
            int x = mid / n, y = mid % n;
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] < target) l = mid + 1;
            else if(matrix[x][y] > target) r = mid - 1;
        }
        return false;
    }
}
