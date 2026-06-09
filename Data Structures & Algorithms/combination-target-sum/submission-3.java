class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backTrack(nums, target, 0);
        return ans;
    }

    public void backTrack(int[]nums, int target, int start){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            sum += nums[i];
            backTrack(nums, target, i);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
