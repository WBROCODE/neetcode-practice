class Solution {
    int[][]memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new int[n + 2][n + 2];
        for(int[] arr : memo) Arrays.fill(arr, -1);

        int[]points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        for(int i = 1; i <= n; i++){
            points[i] = nums[i - 1];
        }
        return dp(points, 0, n + 1);
    }

    public int dp(int[]points, int i, int j){  
        if(i == j) return 0;  
        if(memo[i][j] != -1) return memo[i][j];

        int ans = 0;
        for(int l = i + 1; l < j; l++){
            ans = Math.max(
                ans,
                points[l] *  points[i] *  points[j]
                +
                dp(points, i, l)
                +
                dp(points, l, j)
            );
        }

        memo[i][j] = ans;
        return ans;
    }
}
