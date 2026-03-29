class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(nums, target, 0);
        return ans;
    }

    public void backTrack(int[]nums, int target, int start){
        if(sum > target) return;
        if(sum == target) ans.add(new ArrayList<>(track));
        for(int i = start; i < nums.length; i++){
            sum += nums[i];
            track.add(nums[i]);
            backTrack(nums, target, i);
            track.removeLast();
            sum -= nums[i];
        }
    }
}
