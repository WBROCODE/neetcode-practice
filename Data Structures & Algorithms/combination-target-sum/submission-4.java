class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0, target);
        return ans;
    }

    public void dfs(int[]nums, int start, int target){
        if(target == sum){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            sum += nums[i];
            dfs(nums, i, target);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
