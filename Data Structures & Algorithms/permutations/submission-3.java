class Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[]visited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[nums.length];
        backTrack(nums, 0);
        return ans;
    }

    public void backTrack(int[]nums, int start){
        if(nums.length == path.size()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backTrack(nums, start);
                path.remove(path.size() - 1);
                visited[i] = false;
            }

        }
    }
}
