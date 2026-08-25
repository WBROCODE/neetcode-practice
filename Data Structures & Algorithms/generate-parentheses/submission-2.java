class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        bT(n, 0, 0);
        return ans;
    }

    public void bT(int n, int l, int r){
        if(l == n && l == r){
            ans.add(sb.toString());
            return;
        }
        if(l > n || r > n) return;
        if(r > l){
            return;
        }
        sb.append("(");
        bT(n, l + 1, r);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        bT(n, l, r + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
