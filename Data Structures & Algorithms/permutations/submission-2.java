class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[]used;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[nums.length];
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[]nums, int start){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }


        for(int i = start; i < nums.length; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, start);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }

}
