class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        bT(nums, 0);
        return ans;
    }

    public void bT(int[] nums, int start){
        ans.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            bT(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
