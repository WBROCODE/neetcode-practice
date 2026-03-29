class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    public void dfs(int[]nums, int start, int target){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
