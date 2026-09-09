class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>(); 

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        bT(nums, 0, target);
        return ans;
    }

    public void bT(int[]nums, int start, int target){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            bT(nums, i, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }

    
}
