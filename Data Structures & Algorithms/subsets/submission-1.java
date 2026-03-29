class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[]nums, int start){
        ans.add(new ArrayList<>(path));
    
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
