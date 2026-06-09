class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        bT(nums, 0);
        return ans;
    }

    public void bT(int[] nums, int start){
        ans.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            bT(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
