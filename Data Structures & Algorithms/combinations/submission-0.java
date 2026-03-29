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
        path.add(start);
        backTrack(n, k, start + 1);
        path.remove(path.size() - 1);
        backTrack(n, k, start + 1);
        

    }
}