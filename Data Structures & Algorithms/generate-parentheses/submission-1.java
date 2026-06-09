class Solution {
    StringBuilder sb;
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        backTrack(0, 0, n);
        return ans;
    }

    public void backTrack(int l, int r, int n){
        if(l == n && r == n){
            ans.add(sb.toString());
            return;
        }

        if(l > n || r > l) return;

        sb.append('(');
        backTrack(l + 1, r, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backTrack(l, r + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
