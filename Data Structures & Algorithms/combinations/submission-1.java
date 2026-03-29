class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return ans;
    }

    public void backTrack(int n, int k, int start){
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(start > n) return;
        for(int i = start; i <= n; i++){
            path.add(i);
            backTrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}