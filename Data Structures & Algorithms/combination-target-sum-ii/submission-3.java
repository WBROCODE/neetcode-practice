class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /**
        
                1 2 2 4 5 6 9 
              2  
            2    
        
        */
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        path = new ArrayList<>();
        bT(candidates, target ,0);
        return ans;
    }

    public void bT(int[] nums, int target, int start){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            bT(nums, target - nums[i], i + 1);
            path.remove(path.size() - 1);
        }

    }
}
