class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0);
        return ans;
    }

    public void bt(int[] nums, int target, int start){
        if(target == sum){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(target < sum){
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            sum += nums[i];
            path.add(nums[i]);
            bt(nums, target, i +1);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }

    }
}
