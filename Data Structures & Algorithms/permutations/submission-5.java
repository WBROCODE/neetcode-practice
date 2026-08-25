class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        bT(nums);
        return ans;
    }

    public void bT(int[] nums){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(path.size() > nums.length){
            return;
        }        

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            bT(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }
}
