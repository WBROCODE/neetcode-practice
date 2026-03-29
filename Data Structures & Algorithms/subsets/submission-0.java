class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return ans;
    }


    public void backtrack(int start, int[] nums){
        ans.add(new ArrayList<>(track));

        for(int i = start; i < nums.length; i++){
            track.add(nums[i]);
            backtrack(i + 1, nums);
            track.removeLast();
        }



    }
}
