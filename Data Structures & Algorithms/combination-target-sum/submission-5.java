class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, target, 0);
        return ans;
    }

    public void dfs(int[]nums, int target, int start){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        }
    }
}
