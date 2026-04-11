class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bt(nums, target, path, ans, 0);
        return ans;
    }

    public void bt(int[]nums, int target, List<Integer>path, List<List<Integer>>ans, int start){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            bt(nums, target-nums[i], path, ans, i);
            path.remove(path.size() - 1);
        }
    }
}
