class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0, down = m - 1;
        int left = 0, right = n - 1;

        while(up <= down){
            int mid = up + (down - up) / 2;
            if(matrix[mid][right] == target || matrix[mid][left] == target) return true;
            else if(matrix[mid][right] < target) up = mid + 1;
            else if(matrix[mid][left] > target){
                down = mid - 1;
            }else{
                break;
            }
        }

        if(!(up <= down)) return false;
        int midV = up + (down - up) / 2;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[midV][mid] == target) return true;
            else if(matrix[midV][mid] < target) left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
