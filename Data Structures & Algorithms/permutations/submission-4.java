class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[]visited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[nums.length];
        backTrack(nums);
        return ans;
    }

    public void backTrack(int[]nums){
        if(nums.length == path.size()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backTrack(nums);
                path.remove(path.size() - 1);
                visited[i] = false;
            }

        }
    }
}
