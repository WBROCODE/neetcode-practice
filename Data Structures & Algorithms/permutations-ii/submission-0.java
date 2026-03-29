class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[]visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backTrack(nums);
        return ans;
    }

    public void backTrack(int[] nums){

        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            path.add(nums[i]);
            visited[i] = true;
            backTrack(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }


    }
}